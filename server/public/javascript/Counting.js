

let counter = document.getElementById("counter2").innerHTML
counter = 0;

// function fetching() {
//   fetch()
// }

const fetching = document.getElementById("button");
fetching.onclick = () => {
  console.log("we are fetching")
	fetch("/Counting").then((response) => {
		return response.text();
	}).then((responseText) => {
		const randomString = document.getElementById("counter2");
		randomString.innerHTML = responseText;
    console.log(responseText)
	})
};