Feature: When I want to add course name
  Scenario: I would call some tables
    When : I am calling this table CourseEntity
    Then : I add value in this table
      | id | title | description          |
      | 5  | leidi | how to solve problem |

    When : then I will get the same data which is upload from endpoint
      | 5 | leidi | how to solve problem |



