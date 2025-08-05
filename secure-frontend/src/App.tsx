import './App.css'
import Login from './Components/Login';
import Register from './Components/Register';
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
      <Register />
    </>
  )
}

export default App
