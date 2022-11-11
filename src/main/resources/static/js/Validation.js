const passwordInput = document.querySelector("#password");
const repeatPasswordInput = document.querySelector("#repeatpassword");

passwordInput.addEventListener("input", (e) => {
    if (repeatPasswordInput.value) {
        validateRepeatPasswordMatch();
    }

    if (passwordIsWeak()) {
        passwordInput.classList = ["weak"];
    } else {
        passwordInput.classList = [];
    }
});

repeatPasswordInput.addEventListener("input", (e) => {
    validateRepeatPasswordMatch();
});

const validateRepeatPasswordMatch = () => {
    if (repeatPasswordInput.value != passwordInput.value.slice(0, repeatPasswordInput.value.length)) {
        repeatPasswordInput.setCustomValidity("Does not match password");
    } else {
        repeatPasswordInput.setCustomValidity("");
    }

    repeatPasswordInput.reportValidity();
}

const passwordIsWeak = () => passwordInput.value.length < 12;
