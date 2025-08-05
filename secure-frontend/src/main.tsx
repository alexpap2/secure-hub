import { createRoot } from 'react-dom/client'
import { BrowserRouter } from 'react-router-dom';
import Home from './Components/Home';
import { Route, Routes } from 'react-router';
import Login from './Components/Login';
import Register from './Components/Register';

createRoot(document.getElementById('root')!).render(
  
  <BrowserRouter>
    <Routes>
      <Route path='/' element={<Home />} />
      <Route path='/login' element={<Login />} />
      <Route path='/register' element={<Register />} />
    </Routes>
  </BrowserRouter>
)

