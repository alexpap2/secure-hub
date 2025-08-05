import { Link } from "react-router"
import "../Styles/Home.css"
import axios from "axios";
import { useEffect, useState } from "react";

export default function Home() {

    const[name, setName] = useState('');


    useEffect(() => {
        fetchName();
    }, [])

    function fetchName() {
        axios.get("http://localhost:8080/auth/test/resource", {
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}` 
        }
        })
        .then((response) => {
            setName(response.data);
        })
    }

    function handleResource(event: React.MouseEvent<HTMLAnchorElement, MouseEvent> ) {
        event.preventDefault();
        axios.get("http://localhost:8080/auth/test/resource", {
        headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}` 
        }
        })
        .then(() => { // (response) => {
            // alert(response.data);
            window.location.href = "https://ia801700.us.archive.org/11/items/rick-astley-never-gonna-give-you-up-video_202011/Rick%20Astley%20-%20Never%20Gonna%20Give%20You%20Up%20%28Video%29.mp4";
        })
        .catch(error => alert('not logged in!! you got error ' + error))
    }
    

    return (
        <div className="container">
            <div className="top-part">
                <div className="blob-wrapper">
                    <h1>Secure Hub</h1>
                    {name ? "Signed in as " + name : ''}
                    <div className="blob"></div>
                </div>
                <div className="nav">
                    <div className="top-left-part">
                        <Link to="/login">Login</Link>
                    </div>
                    <div className="top-right-part">
                        <Link to="/register">Register</Link>
                    </div>
                </div>
            </div>
            <div className="bottom-part">
                <div className="arrow">
                    <p>⬇</p>
                </div>
                <div className="headers">
                    <h1>Built with Spring Security<br />for Maximum Protection</h1>
                    <h1>and React + TypeScript<br /> for Easy Scalability</h1>
                </div>                    
                <div className="protected-resource">
                    <h1>all to protect <a href="" onClick={handleResource}>this</a> resource</h1>
                </div>
            </div>
        </div>
    )
}