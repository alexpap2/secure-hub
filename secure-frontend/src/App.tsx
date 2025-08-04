import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './Components/Login';
// import axios from 'axios';

function App() {

  // axios.post('http://localhost:8080/auth/test/login', {
  //   username: 'baboo',
  //   password: 'xontros'
  // })
  // .then(function (response) {
  //   localStorage.setItem("token", response.data);
  // })
  // .catch(function (error) {
  //   console.log(error);
  // });

  // axios.get('http://localhost:8080/auth/test/all', {
  //   headers: {
  //     Authorization: `Bearer ${localStorage.getItem('token')}` 
  //   }
  // })
  // .then(response => console.log(response));

  return (
    <>
      <Login />
    </>
  )
}

export default App
