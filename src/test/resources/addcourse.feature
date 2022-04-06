Feature: When I want to add course name
  Scenario: I would call some tables
    Given : the following table
      | id | title | description          |
      | 5  | leidi | how to solve problem |
    Then : I will get the same data which is upload from endpoint
      | 5 | leidi | how to solve problem |
