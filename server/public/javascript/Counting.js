

let counter = document.getElementById("counter2").innerHTML
counter = 0;

// function fetching() {
//   fetch()
// }

const fetching = document.getElementById("button");
fetching.onclick = () => {
	fetch("/Counting").then((response) => {
		return response.text();
	}).then((responseText) => {
		const randomString = document.getElementById("counter2");
		randomString.innerHTML = responseText;
	})
};


//Web socket stuff
const socketButton = document.getElementById("socketButton");
const socketCounter = document.getElementById("socketCounter");

const socketRoute = document.getElementById("ws-route").value;
const socket = new WebSocket(socketRoute.replace("http","ws"));

socketButton.onClick = (event) => {
  socket.send("1");
}

//Someone else hit button
socket.onmessage = (event) => {
  socketCounter.value = event.data;
}