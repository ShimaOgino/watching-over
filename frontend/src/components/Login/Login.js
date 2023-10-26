import React from "react";
import "./Login.css"; // Styles will be separated

export default function Login() {
  return (
    <div className="login-container">
      <h2>Login</h2>
      <form action="/login" method="post">
        <div className="input-container">
          <input type="text" id="username" name="username" required />
          <label htmlFor="username">Username</label>
        </div>
        <div className="input-container">
          <input type="password" id="password" name="password" required />
          <label htmlFor="password">Password</label>
        </div>
        <button className="login-btn" type="submit">
          Login
        </button>
      </form>
      <div className="signup-link">
        <p>
          Don't have an account? <a href="/signup">Sign up</a>
        </p>
      </div>
    </div>
  );
}
