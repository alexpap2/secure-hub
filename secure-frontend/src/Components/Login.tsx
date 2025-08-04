import axios from "axios"
import "../Styles/Form.css"

export default function Login() {

    function handleLogin(formdata: FormData) {
        const data = Object.fromEntries(formdata);
        axios.post('http://localhost:8080/auth/test/login', {
           username: data.username,
           password: data.password
        })
        .then(function (response) {
        // localStorage.setItem("token", response.data);
            console.log(response.data);
        })
        .catch(function (error) {
            console.log(error);
        });
        
    }

    return (
        <>
          <form action={handleLogin}>
            <div className="formDiv">
              <h1>Login Form</h1>
              <label>Username</label>
              <input type = "text" name = "username" />
              <label>Password</label>
              <input type="text" name="password"/>
              <button type="submit">Log in</button>
            </div>
          </form>
        </>
    )
}