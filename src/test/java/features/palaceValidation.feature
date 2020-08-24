Feature: Validating Place API's

  @AddBook @Regression
  Scenario Outline: Verify if Book is being Successfully added
    Given Add Book Payload with "<name>" and "<isbn>" and "<aisle>" and "<author>"
    When user calls "AddBook" method with POST request
    Then response "<code>" and has "<message>" and has "<ID>"

Examples:
    |name  | isbn     | aisle    | author  | code | message            | ID           |
    |Karl  | English  | World    | author1 | 200  | successfully added | EnglishWorld |
    |Marl  | Waralaa  | Topic    | author2 | 200  | successfully added | WaralaaTopic |

