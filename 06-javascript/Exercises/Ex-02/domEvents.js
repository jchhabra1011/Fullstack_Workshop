const app = document.getElementById("app");
const navLinks = document.querySelectorAll(".nav-link");
const cards = document.querySelectorAll(".card");

const btn = document.getElementById("btn");

btn.onclick = () => {
    console.log("Button clicked");
    btn.textContent = "Clicked!";
};

document.getElementById("search-form").onsubmit = function (e) {
    e.preventDefault();
    let value = document.getElementById("search-input").value;
    console.log(value);
};

document.getElementById("todo-list").onclick = function (e) {
    if (e.target.className === "delete") {
        e.target.parentElement.remove();
    }
};

let count = 0;
const countText = document.getElementById("count");

document.getElementById("increment").onclick = () => {
    count++;
    countText.textContent = count;
};

document.getElementById("decrement").onclick = () => 
    {
    if (count > 0) 
        {
        count--;
        countText.textContent = count;
    }
};

const toggleBtn = document.getElementById("toggle-btn");
const details = document.getElementById("details");

toggleBtn.onclick = () => 
    {
    details.classList.toggle("hidden");
    toggleBtn.textContent =
        details.classList.contains("hidden")
            ? "Show Details"
            : "Hide Details";
};

document.getElementById("signup-form").onsubmit = function (e) 
{
    e.preventDefault();

    let username = document.getElementById("username");
    let email = document.getElementById("email");

    let valid = true;

    if (username.value.length < 3) {
        document.getElementById("username-error").textContent = "Too short";
        valid = false;
    } else {
        document.getElementById("username-error").textContent = "";
    }

    if (!email.value.includes("@")) {
        document.getElementById("email-error").textContent = "Invalid email";
        valid = false;
    } else {
        document.getElementById("email-error").textContent = "";
    }

    if (valid) {
        console.log("Form Submitted");
    }
};
