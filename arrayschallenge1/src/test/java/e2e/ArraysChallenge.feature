Feature: Array challenge

  @smoketest
  Scenario Outline: Find an element in array such that sum of left array is equal to sum of right array
    Given User is on Home page
    And user has a set of array values as <num1><num2><num3><num4><num5><num6><num7><num8><num9>
    When user find the sum of integers at the index on the left is equal to the sum of integers on the right
    Then user return the index of array
    And user exit the page

    Examples: 
      | num1 | num2 | num3 | num4 | num5 | num6 | num7 | num8 | num9 |
      |   23 |   50 |   63 |   90 |   10 |   30 |  155 |   23 |   18 |
      |  133 |   60 |   23 |   92 |    6 |    7 |  168 |   16 |   19 |
      |   30 |   43 |   29 |   10 |   50 |   40 |   99 |   51 |   12 |
