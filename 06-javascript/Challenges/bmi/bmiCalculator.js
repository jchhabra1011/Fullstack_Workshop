console.log("Welcome to BMI calculator..")
let userWeight = prompt('What is your weight?');
console.log('User entered:(kg)', userWeight);

let userHeight = prompt('What is your hieght?');
console.log('User entered:(metres)', userHeight);

userWeight = Number(userWeight);
userHeight = Number(userHeight);

let bmi = userWeight / (userHeight * userHeight);

console.log('User BMI is:', bmi);

checkBMI(bmi);

function checkBMI(bmi) 
{
    if (bmi < 18.5) 
        {
            console.log("Underweight");
        } 
    else if (bmi >= 18.5 && bmi <= 24.9) 
        {
            console.log("Normal");
        } 
    else if (bmi >= 25 && bmi <= 29.9) 
        {
            console.log("Overweight");
        } 
    else 
        {
            console.log("Obese");
        }
}