const form = document.querySelector('form');
const email = document.querySelector('#email');
const password = document.querySelector('#password');
const cpassword = document.querySelector('#cpassword');

form.addEventListener('submit', (e) => {
    e.preventDefault();
    validateInputs();
});

const setError = (element, message) => {
    const info = element.parentElement;
    const error = info.querySelector('#error');

    error.innerText = message;
    info.classList.add('bad');
}

const setSuccess = (element) => {
    const info = element.parentElement;
    info.classList.remove('bad');

    error.innerText = "";
}

const isValidEmail = (email) => {
    const reg = /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}/;
    return reg.test(email.value.trim().toLowerCase());
};

function validateInputs () {
    const emailVal = email.value.trim();
    const passwordVal = password.value.trim();
    const cpasswordVal = cpassword.value.trim();

    let validEmail = false;
    let validPass = false;

    if (emailVal === '') {
        setError(email, 'email is required');
    } else if (!isValidEmail(email)) {
        setError(email, 'invlaid email');
    } else {
        setSuccess(email);
        validEmail = true;
    }
    if (passwordVal === '') {
        setError(password, 'password is required');
    } else if (passwordVal.length < 8) {
        setError(password, 'password must be at least 8 characters');
    } else if (passwordVal != cpasswordVal) {
        setError(cpassword, 'passwords must match');
    } else {
        setSuccess(password);
        validPass = true;
    }

    return validEmail && validPass;
}
