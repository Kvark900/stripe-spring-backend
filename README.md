<p align="center">
  <h3 align="center">stripe-spring-backend</h3>

  <p align="center">
    Spring Boot server for Stripe payments
    <br />
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project


### Built With
* [Kotlin](https://kotlinlang.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Stripe](https://stripe.com/)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

Create a Stripe account and go to stripe dashboard > Developers > copy/paste Secret key
to ```application.properties``` file:

```
 STRIPE_SECRET_KEY=
 ```

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Kvark900/stripe-spring-backend.git
   ```
2. Run the main method

<!-- USAGE EXAMPLES -->
## Usage
Use ```/create-checkout-session``` endpoint to get URL for stripe checkout page.

Use any of these test cards to simulate a payment.

```sh
4242 4242 4242 4242
Payment requires authentication

4000 0025 0000 3155
Payment is declined

4000 0000 0000 9995 
Payment succeeds
   ```






