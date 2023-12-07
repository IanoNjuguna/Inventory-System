import './style.css'


const message: string = "Hello, World!";
console.log(message);

// You can also modify the DOM
const appElement: HTMLElement | null = document.getElementById('app');
if (appElement) {
  appElement.innerText = message;
}