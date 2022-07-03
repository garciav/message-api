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
	}, function (error) {
		alert("error!")
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
let count = 0;
const showGreeting = (message) => {
	if (document.hidden) {
		count ++ 
		document.title = "(" + count + ") " + "Message Group";
	}
	$("#greetings").append("<tr><td>" + message + "</td></tr>");
}

const resetNotification = () => {
	document.title = "Message Group";
	count = 0;
}
$(() => {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
	const messaging = firebase.messaging();
	messaging.onMessage((payload) => {
		alert('Message received. ' + payload);
		console.log('Message received. ', payload);
	});	
	    
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    
    window.onfocus = resetNotification;
});