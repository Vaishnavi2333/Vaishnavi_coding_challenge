
import  { useState } from 'react';
import axios from 'axios';

export function SearchPlayersByRole() {
    const [role, setRole] = useState("");      
    const [playerList, setPlayerList] = useState([]);

    const handleSearch = () => {

        const Roles = ["Batsman", "Bowler", "Keeper", "All Rounder"];

       
        if (!Roles.includes(role)) {
        alert("Enter a valid role");
        return;
    }

       
        axios.get(`http://localhost:8080/player/getbyrole?role=${role}`)
            .then((response) => {
                console.log(response.data);
                setPlayerList(response.data);
            })
            .catch((error) => {
                console.error("Error fetching players:", error);
            });
    };

    return (
        <div style={{ marginTop: "20px" }}>
            <input type="text" value={role} onChange={(e) => setRole(e.target.value)} className="form-control"
              style={{ width: "300px", display: "inline-block", marginRight: "10px" }}
            />
            <button onClick={handleSearch} className="btn btn-primary">Search </button>

            <ul style={{ marginTop: "20px" }}>
                {playerList.map((player) => (
                    <li key={player.playerId} style={{ margin: "15px 0", padding: "10px", border: "1px solid #ccc", borderRadius: "8px" }}>
                        <p><strong>ID:</strong> {player.playerId}</p>
                        <p><strong>Player Name:</strong> {player.playerName}</p>
                        <p><strong>Jersey Number:</strong> {player.jerseyNumber}</p>
                        <p><strong>Role:</strong> {player.role}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}
