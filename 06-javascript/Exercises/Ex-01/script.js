console.log('Hello from external file!');
console.log('This is a log message');
console.warn('This is a warning');
console.error('This is an error');
console.info('This is info');
console.log('Name:', 'John', 'Age:', 25);
console.log({ name: 'John', age: 25 });
console.table([
    { name: 'John', age: 25 },
    { name: 'Jane', age: 30 }
]);
let name = 'Alice';
let age = 28;
console.log(`${name} is ${age} years old`);
console.log(name + ' is ' + age + ' years old');
console.log('Name: %s, Age: %d', name, age);
alert('Welcome to JavaScript!');
let userName = prompt('What is your name?');
console.log('User entered:', userName);
let isConfirmed = confirm('Do you want to continue?');
console.log('User confirmed:', isConfirmed);

let newname = prompt('What is your name?');
let color = prompt('What is your favorite color?');

// writing components
function greet(name) {
    return 'Hello, ' + name;
}

//organizing script
const APP_NAME = 'My JavaScript App';
const VERSION = '1.0.0';
console.log(`${APP_NAME} v${VERSION}`);

// calculator
let num1 = prompt('Enter first number:');
let num2 = prompt('Enter second number:');
num1 = Number(num1);
num2 = Number(num2);
let sum = num1 + num2;
let difference = num1 - num2;
let product = num1 * num2;
let quotient = num1 / num2;
console.log('Sum:', sum);
console.log('Difference:', difference);
console.log('Product:', product);
console.log('Quotient:', quotient);

//basic string operation
let message = 'Hello, JavaScript!';
console.log('Length:', message.length);
console.log('Uppercase:', message.toUpperCase());
console.log('Lowercase:', message.toLowerCase());
console.log('First char:', message[0]);
console.log('Last char:', message[message.length - 1]);
console.log('Has "Java":', message.includes('Java'));
console.log('Replaced:', message.replace('JavaScript', 'World'));
