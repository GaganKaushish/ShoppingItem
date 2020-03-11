Feature: Test Checkout flow for purchasing pillow

Scenario Outline: Test with Successful payment flow
		Given Open Browser and start Application
		When User enter "<CardNumber>" and "<ExpiryDate>" with "<CVV>"
		Then User should be able to purchase pillow
		
		Examples:
						|CardNumber         |ExpiryDate |CVV |
						|4811 1111 1111 1114|0320       |123 |