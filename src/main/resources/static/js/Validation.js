const passwordInput = document.querySelector("#password");
const repeatPasswordInput = document.querySelector("#repeatpassword");

passwordInput.addEventListener("input", (event) => {
    checkPasswordStrenght(event);
    if (passwordsMatch(repeatPasswordInput, event.target.value)) {
        repeatPasswordInput.classList = ["strong-password"];
    } else {
        repeatPasswordInput.classList = ["invalid-password"];
    }
});

repeatPasswordInput.addEventListener("input", (event) => {
    if (passwordsMatch(passwordInput, event.target.value)) {
        repeatPasswordInput.classList = ["strong-password"];
    } else {
        repeatPasswordInput.classList = ["invalid-password"];
    }
});

const passwordsMatch = (element, password) => {
    return element.value === password;
}

function comparePassword() {
    const pass = getElement("password");
    const repeatPass = getElement("repeatpassword");

    if (pass && repeatPass) {
        pass.addEventListener("input", compare);
        repeatPass.addEventListener("input", compare);

        function compare() {
            if (pass.value === repeatPass.value) {
                repeatPass.setCustomValidity("");
            } else {
                repeatPass.setCustomValidity("Passwords do not match");
            }
        }

        pass.removeEventListener("input", compare);
        repeatPass.removeEventListener("input", compare);
    }
}

function getElement(name) {
    return document.getElementById("participantFromBean").querySelector(`input[name=${name}]`);
}

function checkPasswordStrenght(event) {
    const password = event.target.value;
    if (password.length > 10) {
        // strong
        event.target.classList = ["strong-password"];
    } else if (password.length > 5) {
        // medium
        event.target.classList = ["medium-password"];
    } else {
        // invalid
        event.target.classList = ["invalid-password"];
    }
}

document.querySelector("form").addEventListener("submit", (e) => {
    if (!e.target.gender.value || e.target.password.value !== e.target.repeatpassword.value) {
        e.preventDefault();
    }
});
