import axios from "axios";
import { Component } from "react";


export class PutPlayer extends Component{


     constructor(props){
        super(props)

        this.state={
            "playerId":0,
            "playerName":"playerName",
            "jerseyNumber":1,
            "role":"Batsman",
             "totalMatches": 10,
            "teamName": "teamName",
            "stateName": "stateName",
            "description": "description"
        }
     }

     handleChange=(e)=>{
        this.setState({[e.target.name]:e.target.value})

     }

     handleSubmit=(e)=>{

       const{playerName,jerseyNumber} = this.state;
        e.preventDefault();
        console.log(this.state);
        if (!playerName.trim()) {
        alert("Player Name is required");
         return;
         }
         if(jerseyNumber<=0){
            alert("Enter valid jersey Number")
         }
       
        console.log(this.state);
        axios.put("http://localhost:8080/player/update/"+this.state.playerId,this.state)
        .then(response=>{
            console.log(response.data)
        }) .catch((error) => {
            if (error.response && error.response.status === 500) {
                alert("Player ID not found");
            }
                console.error(error);
            });
     }

     render(){
        const{playerId,playerName,jerseyNumber,role} = this.state;

        return(
        <div>

            <h1>Update Player Details</h1>

            <form onSubmit={this.handleSubmit}>


                <label htmlFor="playerId">Player Id:</label>
                <input type="number" className="form-control" name="playerId" value={playerId} onChange={this.handleChange}></input>
                  <label htmlFor="playerName">Player Name:</label>
                <input type="text" className="form-control" name="playerName" value={playerName} onChange={this.handleChange}></input>
                  <label htmlFor="jerseyNumber">Jersey Number:</label>
                <input type="number" className="form-control" name="jerseyNumber" value={jerseyNumber} onChange={this.handleChange}></input>
                  <label htmlFor="role">Role:</label>
                  <select className="form-select"  name="role" value={role} onChange={this.handleChange}>
                     <option value=""> Select Role </option>
                     <option value="Batsman">Batsman</option>
                     <option value="Bowler">Bowler</option>
                     <option value="Keeper">Keeper</option>
                     <option value="All Rounder">All Rounder</option>
                  </select>
               
                <button type="submit" className='btn btn-success mt-4 text-white' >Edit Player</button>


            </form>





        </div>
        )
     }


    }