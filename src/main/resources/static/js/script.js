document.addEventListener("DOMContentLoaded",OndomContentLoaded);
function OndomContentLoaded(){
    const submitBtn=document.getElementById("submitBtn");

    submitBtn.addEventListener("click",onSubmitClick);
}

function onSubmitClick(){
    const UserInput=document.getElementById("userInput");

    const username=UserInput.value.trim();

    if(username===""){
        alert("Please enter a username");
        return;
    }

    console.log("Github username:"+username);

    fetchUserPullRequests(username);
}
function fetchUserPullRequests(username){
    console.log("Fetching user pull requests");
    axios.get("http://localhost:8080/prs/"+username)
        .then(response=>{
            console.log("pull req"+response.data);
            console.log("JSON string:", JSON.stringify(response.data, null, 2));
            displayPullRequests(response.data);
        })
        .catch(error=>{
            console.log("error"+error);
            alert("Error fetching pull requests. Please try again.");

        });
}
function displayPullRequests(data){
    const prResults=document.getElementById("pr-results");
    prResults.innerHTML="";

    data.forEach(item=>{
       const orgElement=document.createElement("div");
       orgElement.className="organization";
       orgElement.textContent=item.fullname||"Unknown org";

       const prElement=document.createElement("div");
       prElement.className="pull-title";
        prElement.textContent=item.title||"Unknown PR";

        prResults.appendChild(orgElement);
        prResults.appendChild(prElement);
    });
}