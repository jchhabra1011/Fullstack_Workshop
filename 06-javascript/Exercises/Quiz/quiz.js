let score = 0;
let answer1 = prompt("Question 1:\nWhat is 5 + 3?");
if (answer1 == 8) {
    console.log("Correct!");
    score = score + 1;
} else {
    console.log("Wrong! Correct answer is 8");
}
let answer2 = prompt("Question 2:\nWhat is the capital of France?");
answer2 = answer2.toLowerCase();
if (answer2 == "paris") {
    console.log("Correct!");
    score = score + 1;
} else {
    console.log("Wrong! Correct answer is Paris");
}
let answer3 = prompt("Question 3:\nWhat color is the sky?");
answer3 = answer3.toLowerCase();
if (answer3 == "blue") {
    console.log("Correct!");
    score = score + 1;
} else {
    console.log("Wrong! Correct answer is Blue");
}

console.log("Quiz Finished!");
console.log("Your final score is: " + score + " out of 3");
