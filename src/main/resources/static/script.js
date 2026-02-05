<!DOCTYPE html>
<html>
<head>
    <title>Automated Credit Score Analysis</title>
</head>
<body>

<h2>Automated Credit Score Analysis</h2>

<label>Enter Your Income:</label><br><br>

<input type="number" id="income" placeholder="Enter income"><br><br>

<button onclick="checkScore()">Check Credit Score</button>

<p id="result"></p>

<script>
function checkScore() {

    var income = document.getElementById("income").value;

    if (income === "") {
        alert("Please enter income");
        return;
    }

    fetch("http://localhost:8080/credit-score/calculate?income=" + income)
        .then(response => response.text())
        .then(score => {
            document.getElementById("result").innerHTML =
                "Your Credit Score is: " + score;
        })
        .catch(error => {
            alert("Error while calling backend");
        });
}
</script>

</body>
</html>
