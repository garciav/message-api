let stompClient = null;

const setConnected = (connected) => {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}
let group = undefined;
const connect = () => {
    let socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);

	//FIXME: USER SESSION
	let userData = {
		userId: 1,
		name: "Jhon"
	}
	fetch('/groups/1')
		.then(response => {
			response.json().then(groupData => {
				group = groupData;
				console.log("resp : " + groupData);
			});
		});

	fetch('/messages')
		.then(response => response.json())
		.then(data => {
			data.forEach((current) => {
				showGreeting(current.content);
			});
		});

	stompClient.subscribe('/topic/greetings', function (greeting) {
		showGreeting(JSON.parse(greeting.body).content);
		$("#name").val('');
	});
});
}

const disconnect = () => {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

const sendName = () => { 
    stompClient.send("/app/hello", {}, JSON.stringify({'group': {'id': group.id},'content': $("#name").val()}));
}

const showGreeting = (message) =>{
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(() => {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});