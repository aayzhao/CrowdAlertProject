import React from 'react';
import ReactDOM from 'react-dom';
import { initializeApp } from "firebase/app";
import { getAuth, createUserWithEmailAndPassword } from "firebase/auth";

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyCiGwRzFvRdD-j32SvbpBZZ_UelNGq9IHs",
  authDomain: "crowdalertproject.firebaseapp.com",
  projectId: "crowdalertproject",
  storageBucket: "crowdalertproject.appspot.com",
  messagingSenderId: "624957518219",
  appId: "1:624957518219:web:b835cb97bf4a105d2c7f8e",
  measurementId: "G-Y62FMTF7BS"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

function SignUp() {
    const auth = getAuth();
    
    function handleSubmit(e) {
        e.preventDefault();

        const email = e.target.email.value;
        const password = e.target.password.value;

        createUserWithEmailAndPassword(auth, email, password)
            .then((userCredential) => {
                // Sending verification email
                userCredential.user.sendEmailVerification()
                    .then(() => {
                        alert("Verification email sent! Please check your inbox.");
                    });
            })
            .catch((error) => {
                alert(error.message);
            });
    }

    return React.createElement('form', { onSubmit: handleSubmit },
        React.createElement('input', { type: 'email', name: 'email', placeholder: 'Email', required: true }),
        React.createElement('input', { type: 'password', name: 'password', placeholder: 'Password', required: true }),
        React.createElement('button', { type: 'submit' }, 'Sign Up')
    );
}

ReactDOM.render(
    React.createElement(SignUp, null),
    document.getElementById('root')
);
