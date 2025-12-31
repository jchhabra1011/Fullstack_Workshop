const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const submitBtn = document.getElementById("submitBtn");


function showError(input, message) {
    input.classList.add("invalid");
    input.classList.remove("valid");
    input.nextElementSibling.textContent = message;
}

function showSuccess(input) {
    input.classList.add("valid");
    input.classList.remove("invalid");
    input.nextElementSibling.textContent = "";
}

function validateUsername() {
    if (username.value.length < 3 || username.value.length > 15) {
        showError(username, "Username must be 3–15 characters");
        return false;
    }
    showSuccess(username);
    return true;
}

function validateEmail() {
    if (!email.value.includes("@") || !email.value.includes(".")) {
        showError(email, "Enter a valid email");
        return false;
    }
    showSuccess(email);
    return true;
}

function validatePassword() {
    if (password.value.length < 8) {
        showError(password, "Minimum 8 characters required");
        return false;
    }
    showSuccess(password);
    return true;
}

function validateConfirmPassword() {
    if (confirmPassword.value !== password.value) {
        showError(confirmPassword, "Passwords do not match");
        return false;
    }
    showSuccess(confirmPassword);
    return true;
}

function checkForm() {
    if (
        validateUsername() &&
        validateEmail() &&
        validatePassword() &&
        validateConfirmPassword()
    ) {
        submitBtn.disabled = false;
        submitBtn.classList.add("enabled");
    } else {
        submitBtn.disabled = true;
        submitBtn.classList.remove("enabled");
    }
}
username.addEventListener("blur", validateUsername);
email.addEventListener("blur", validateEmail);
password.addEventListener("blur", validatePassword);
confirmPassword.addEventListener("blur", validateConfirmPassword);
document.getElementById("registerForm").addEventListener("submit", function (e) {
    e.preventDefault();
    checkForm();
});
