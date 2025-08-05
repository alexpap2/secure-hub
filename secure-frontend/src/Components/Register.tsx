import axios from "axios"
import "../Styles/Form.css"
import { useNavigate } from "react-router";

export default function Login() {

    let navigate = useNavigate();

    function handleLogin(formdata: FormData) {
      const data = Object.fromEntries(formdata);
      axios.post('http://localhost:8080/auth/test/register', {
        username: data.username,
        password: data.password
      })
      .then(function (response) {
        localStorage.setItem("token", response.data);
        if (response.data !== '') {
            alert(response.data);
            navigate(-1);
        }
      })
      .catch(function (error) {
        alert('Error on the backend most likely');
        alert(error);
        console.log(error);
      });
        
    }

    return (
        <div className="formContainer">
          <form action={handleLogin}>
            <div className="formDiv">
              <h1>Register</h1>
              <label>Username</label>
              <input type = "text" name = "username" required />
              <label>Password</label>
              <input type="text" name="password" required />
              <button type="submit">Sign Up</button>
            </div>
          </form>
        </div>
    )
}