// import React from 'react';
// import ReactDOM from 'react-dom';
// import { initializeApp } from "firebase/app";
// import { getAuth, createUserWithEmailAndPassword, sendEmailVerification } from "firebase/auth";

// const firebaseConfig = {
//     apiKey: "AIzaSyCiGwRzFvRdD-j32SvbpBZZ_UelNGq9IHs",
//     authDomain: "crowdalertproject.firebaseapp.com",
//     databaseURL: "https://crowdalertproject-default-rtdb.firebaseio.com",
//     projectId: "crowdalertproject",
//     storageBucket: "crowdalertproject.appspot.com",
//     messagingSenderId: "624957518219",
//     appId: "1:624957518219:web:b835cb97bf4a105d2c7f8e",
//     measurementId: "G-Y62FMTF7BS"
// };
  
// // Initialize Firebase
// const app = initializeApp(firebaseConfig);
// const analytics = getAnalytics(app);

// const SignUp = () => {
//     console.log("Test")
//     const handleSubmit = (e) => {
//         e.preventDefault();
//         const email = e.target.email.value;
//         const password = e.target.password.value;
//         const auth = getAuth();

//         createUserWithEmailAndPassword(auth, email, password)
//             .then((userCredential) => {
//                 sendEmailVerification(userCredential.user)
//                     .then(() => {
//                         alert("Verification email sent! Please check your inbox.");
//                     });
//             })
//             .catch((error) => {
//                 alert(error.message);
//             });
//     };

//     return (
//         <div className="container mt-5">
//             <form onSubmit={handleSubmit} className="w-50 mx-auto">
//                 <div className="form-group">
//                     <input type="email" name="email" className="form-control" placeholder="Email" required />
//                 </div>
//                 <div className="form-group">
//                     <input type="password" name="password" className="form-control" placeholder="Password" required />
//                 </div>
//                 <button type="submit" className="btn btn-primary">Sign Up</button>
//             </form>
//         </div>
//     );
// };


// export default App = () => (
//     <div>
//         {/* Your other components here */}
//         <SignUp />
//     </div>
// );

// ReactDOM.render(<App />, document.getElementById('root'));


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;