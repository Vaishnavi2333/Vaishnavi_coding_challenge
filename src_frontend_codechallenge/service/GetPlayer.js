import { useState } from "react";
import axios from "axios";
import { useEffect } from "react";

export function GetPlayer(){

    const[playerList,setPlayerList] = useState([]);

    const get = () =>{
        axios.get("http://localhost:8080/player/getall")
        .then((response)=>{
            console.log(response.data)
            setPlayerList(response.data)
        }).catch((error) =>{
            console.log(error)
        })
    }

    useEffect(() => { 
        get();
  }, []);

    return(

        <div>

            {/* <button type="submit" onClick={get} className='btn btn-success mt-4 text-white'>Get all Players</button> */}
            <ul>
                {playerList.map((player) =>(
                    <li key={player.playerId} style={{ margin: "15px 0", padding: "10px", border: "1px solid #ccc", borderRadius: "8px" }}>
                        <p><strong>ID:</strong>{player.playerId}</p>
                        <p><strong>Player Name:</strong>{player.playerName}</p>
                        <p><strong>Jersey Number:</strong>{player.jerseyNumber}</p>
                        <p><strong>Role:</strong>{player.role}</p>
                      
                    </li>
                ))}
            </ul>


        </div>
    )
}