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
        localStorage.setItem("token", response.data);
        if (response.data !== '') {
          alert(response.data);
          //do sth
        }
      })
      .catch(function (error) {
        alert('Wrong Username or Password!');
        console.log(error);
      });
        
    }

    return (
        <div className="formContainer">
          <form action={handleLogin}>
            <div className="formDiv">
              <h1>Log in</h1>
              <label>Username</label>
              <input type = "text" name = "username" required />
              <label>Password</label>
              <input type="text" name="password" required />
              <button type="submit">Log in</button>
            </div>
          </form>
        </div>
    )
}