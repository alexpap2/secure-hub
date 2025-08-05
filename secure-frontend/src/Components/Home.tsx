import { Link } from "react-router"
import "../Styles/Home.css"

export default function Home() {

    return (
        <div className="container">
            <div className="top-part">
                <div className="blob-wrapper">
                    <h1>Secure Hub</h1>
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
        </div>
    )
}