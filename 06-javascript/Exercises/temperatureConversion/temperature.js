let choice =
    prompt
        (
            "Choose conversion type:\n" +
            "1. Celsius to Fahrenheit\n" +
            "2. Fahrenheit to Celsius"
        );
let temperature = prompt("Enter the temperature value:");
temperature = Number(temperature);
if (choice == 1) {
    let fahrenheit = (temperature * 9 / 5) + 32;
    console.log("Temperature in Fahrenheit is:", fahrenheit);
}
else if (choice == 2) {
    let celsius = (temperature - 32) * 5 / 9;
    console.log("Temperature in Celsius is:", celsius);
}
else {
    console.log("Invalid choice. Please enter 1 or 2.");
}
