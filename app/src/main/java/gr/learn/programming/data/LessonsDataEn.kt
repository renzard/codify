package gr.learn.programming.data

import gr.learn.programming.model.Lesson
import gr.learn.programming.model.Quiz

/** English version of the lessons. Same ids, order and categories as [lessonsEl]. */
val lessonsEn: List<Lesson> = listOf(
    Lesson(
        id = "python_intro",
        title = "1. Introduction to Python",
        category = "Python",
        description = "Python is a high-level programming language created by Guido van Rossum and released in 1991. It reads almost like plain English, which makes it ideal for beginners.\n\n" +
            "It is used for web development, automation, data analysis, artificial intelligence and games. It runs on Windows, Mac, Linux and, of course, on phones.",
        codeExample = """
            print("Hello, world!")
            print("Python is easy")
        """.trimIndent(),
        quiz = Quiz(
            question = "What is one advantage of Python for beginners?",
            options = listOf("Its syntax is easy to read", "It only works on Windows", "It has no variables", "It is only written with curly braces { }"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_syntax",
        title = "2. Syntax",
        category = "Python",
        description = "Syntax is the set of rules for writing code correctly. In Python every statement goes on its own line and you don't need a semicolon at the end.\n\n" +
            "Indentation is mandatory: the spaces at the start of a line show which code belongs to a block. If you get it wrong, the program raises an error.",
        codeExample = """
            if 5 > 2:
                print("5 is greater than 2")
                print("This line belongs to the same block")

            print("This one is outside the block")
        """.trimIndent(),
        quiz = Quiz(
            question = "What does indentation show in Python?",
            options = listOf("Which code belongs to a block", "The color of the code", "The speed of the program", "Nothing, it is optional"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_output",
        title = "3. Output (print)",
        category = "Python",
        description = "The print() function displays text or values on the screen. You can give it several arguments separated by commas and it prints them with a space in between.\n\n" +
            "With the sep argument you change the separator, and with end you change what is printed at the end (normally a new line).",
        codeExample = """
            print("Hello", "there", 2026)
            print("A", "B", "C", sep="-")
            print("No new line", end=" ")
            print("continues here")
        """.trimIndent(),
        quiz = Quiz(
            question = "What does print(\"A\", \"B\", sep=\"-\") print?",
            options = listOf("A-B", "A B", "AB", "A,B"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_comments",
        title = "4. Comments",
        category = "Python",
        description = "Comments are notes for you and for anyone who reads the code. Python ignores them when the program runs.\n\n" +
            "A comment starts with the # symbol. For multi-line comments we usually use several lines starting with #, or a piece of text inside triple quotes.",
        codeExample = """
            # This is a comment
            print("Hi")  # comment at the end of the line

            # print("This line will not run")
            print("The end")
        """.trimIndent(),
        quiz = Quiz(
            question = "Which symbol starts a comment in Python?",
            options = listOf("#", "//", "--", "/*"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_variables",
        title = "5. Variables",
        category = "Python",
        description = "A variable is a “box” in the computer's memory where we store a value to use later. " +
            "We give it a name and, with the = symbol, we assign it a value.\n\n" +
            "In Python you don't have to declare the type of a variable; it figures it out by itself. " +
            "The most common types are integers (int), decimals (float), text (str) and logical values (bool).",
        codeExample = """
            name = "Maria"       # text (str)
            age = 25            # integer (int)
            height = 1.68       # decimal (float)
            is_student = True   # logical value (bool)

            print(name)
            print("My age is", age)

            age = age + 1       # we change the value
            print("Next year I will be", age)
        """.trimIndent(),
        quiz = Quiz(
            question = "Which statement creates a variable named x with the value 10?",
            options = listOf("x = 10", "10 = x", "var x == 10", "x <- 10"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_datatypes",
        title = "6. Data types",
        category = "Python",
        description = "Every value in Python has a type. The basic ones are: str (text), int (integer), float (decimal), bool (True/False), list, tuple, set and dict.\n\n" +
            "With the type() function you can see the type of a value.",
        codeExample = """
            print(type("hello"))
            print(type(10))
            print(type(3.14))
            print(type(True))
            print(type([1, 2, 3]))
            print(type({"name": "Nick"}))
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the type of the value 3.14?",
            options = listOf("int", "float", "str", "bool"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_numbers",
        title = "7. Numbers",
        category = "Python",
        description = "Python has three number types: int (integers), float (decimals) and complex (complex numbers). For simple programs you will mostly use the first two.\n\n" +
            "Integers can be as large as you like. Decimals are written with a dot, not a comma.",
        codeExample = """
            a = 7
            b = 2.5
            big = 10 ** 20

            print(a + b)
            print(type(a), type(b))
            print(big)
            print(7 / 2)    # regular division
            print(7 // 2)   # integer division
            print(7 % 2)    # remainder
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the result of 7 // 2?",
            options = listOf("3.5", "3", "4", "1"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_casting",
        title = "8. Casting (type conversion)",
        category = "Python",
        description = "Casting is converting a value from one type to another. We use the int(), float() and str() functions.\n\n" +
            "It is very useful when you have a number written as text, e.g. \"5\", and you want to do math with it. If the value cannot be converted (e.g. int(\"abc\")), an error occurs.",
        codeExample = """
            x = int("5") + 3
            y = float(2) + 0.5
            z = str(100) + " euros"

            print(x)
            print(y)
            print(z)
            print(int(9.99))   # cuts off the decimal part
        """.trimIndent(),
        quiz = Quiz(
            question = "What does int(9.99) return?",
            options = listOf("10", "9", "9.99", "Error"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_strings",
        title = "9. Strings (text)",
        category = "Python",
        description = "A string is a sequence of characters inside quotes, single or double. Each character has an index that starts at 0, just like in lists.\n\n" +
            "With slicing you take a piece of the text: s[0:3] gives the characters from position 0 up to 2. Strings have many useful methods: upper(), lower(), replace(), split(), strip().",
        codeExample = """
            s = "Hello Python"

            print(len(s))
            print(s[0])
            print(s[0:5])
            print(s.upper())
            print(s.replace("Python", "world"))
            print("Python" in s)
        """.trimIndent(),
        quiz = Quiz(
            question = "What does len(\"abc\") return?",
            options = listOf("2", "3", "4", "abc"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_booleans",
        title = "10. Booleans",
        category = "Python",
        description = "A bool has only two values: True and False. It results from comparing values, e.g. 10 > 5.\n\n" +
            "Almost every value counts as True, except 0, the empty text \"\", the empty list [] and None, which count as False. You can check with bool().",
        codeExample = """
            print(10 > 5)
            print(10 == 5)
            print(bool("hello"))
            print(bool(""))
            print(bool(0))
            print(bool([1]))
        """.trimIndent(),
        quiz = Quiz(
            question = "Which of the following values counts as False?",
            options = listOf("\"0\"", "[0]", "0", "\"False\""),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "python_operators",
        title = "11. Operators",
        category = "Python",
        description = "Operators perform operations. Arithmetic: + - * / // % **. Comparison: == != > < >= <=. Logical: and, or, not.\n\n" +
            "Assignment operators shorten the code: x += 1 is the same as x = x + 1. The in operator checks whether something exists inside a list or text.",
        codeExample = """
            x = 10
            x += 5
            print(x)
            print(2 ** 3)
            print(x > 10 and x < 20)
            print(not True)
            print(3 in [1, 2, 3])
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the ** operator do?",
            options = listOf("Multiplies", "Raises to a power", "Finds the remainder", "Divides"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_lists",
        title = "12. Lists",
        category = "Python",
        description = "A list stores many values in one variable. It is written inside square brackets [ ] and the items are separated by commas.\n\n" +
            "Each item has a position, the index, which starts at 0. " +
            "So the first item is my_list[0], the second is my_list[1], and so on. " +
            "With append() we add an item at the end and with len() we find how many items the list has.",
        codeExample = """
            fruits = ["apple", "banana", "orange"]

            print(fruits[0])          # apple
            fruits.append("cherry")   # add at the end
            print(len(fruits))        # 4

            fruits[1] = "kiwi"        # change an item
            print(fruits)
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the index of the first item of a list in Python?",
            options = listOf("0", "1", "-1", "It depends on the list"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_tuples",
        title = "13. Tuples",
        category = "Python",
        description = "A tuple looks like a list, but it is immutable: after it is created you cannot change, add or remove items. It is written with parentheses ( ).\n\n" +
            "It is used for data that should not change, e.g. coordinates. A tuple with one item needs a comma: (5,).",
        codeExample = """
            point = (10, 20)
            print(point[0])
            print(len(point))

            x, y = point          # unpacking
            print(x, y)

            # point[0] = 99   # This would raise an error!
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the main difference between a tuple and a list?",
            options = listOf("A tuple cannot change after it is created", "A tuple is slower", "A tuple has no indexes", "A list has no order"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_sets",
        title = "14. Sets",
        category = "Python",
        description = "A set is a collection of unique items, without a specific order. It is written with curly braces { }. If you add an item that already exists, it is ignored.\n\n" +
            "It is ideal for removing duplicates and for set operations such as union (|) and intersection (&).",
        codeExample = """
            numbers = {1, 2, 2, 3, 3, 3}
            print(numbers)

            numbers.add(4)
            print(len(numbers))

            a = {1, 2, 3}
            b = {3, 4, 5}
            print(a | b)   # union
            print(a & b)   # intersection
        """.trimIndent(),
        quiz = Quiz(
            question = "How many items does the set {1, 2, 2, 3} have?",
            options = listOf("4", "3", "2", "1"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_dictionaries",
        title = "15. Dictionaries",
        category = "Python",
        description = "A dictionary stores key: value pairs. It is written with { } and you find a value by its key, not by position.\n\n" +
            "With d[\"key\"] you read or change a value; with keys(), values() and items() you get all the keys, values or pairs. get() doesn't raise an error if the key is missing.",
        codeExample = """
            person = {"name": "Maria", "age": 25}

            print(person["name"])
            person["city"] = "Athens"     # new pair
            person["age"] = 26            # change a value

            for key, value in person.items():
                print(key, "->", value)

            print(person.get("color", "unknown"))
        """.trimIndent(),
        quiz = Quiz(
            question = "How do you read the value of the key \"name\" from the dictionary person?",
            options = listOf("person(\"name\")", "person[\"name\"]", "person.name", "person{\"name\"}"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_conditions",
        title = "16. If/Else Conditions",
        category = "Python",
        description = "Conditions let the program make decisions. " +
            "With if we check whether something is true and, only then, the block of code that follows is executed.\n\n" +
            "With elif we add extra checks and with else we define what happens when none of the previous conditions is true. " +
            "Careful: in Python indentation (the spaces at the start of the line) is mandatory and shows which code belongs to the block.",
        codeExample = """
            temperature = 30

            if temperature > 35:
                print("It's a heatwave!")
            elif temperature > 20:
                print("Warm, nice day.")
            else:
                print("Put something warm on.")
        """.trimIndent(),
        quiz = Quiz(
            question = "What will the example code print when temperature = 30?",
            options = listOf("It's a heatwave!", "Warm, nice day.", "Put something warm on.", "Nothing"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_match",
        title = "17. Match",
        category = "Python",
        description = "match is a clean way to check a value against many cases, instead of many elif. It exists since Python 3.10.\n\n" +
            "Each case is written with case. The _ symbol matches anything and works like else. With | you combine several values into one case.",
        codeExample = """
            day = 6

            match day:
                case 1 | 2 | 3 | 4 | 5:
                    print("Weekday")
                case 6 | 7:
                    print("Weekend")
                case _:
                    print("Unknown day")
        """.trimIndent(),
        quiz = Quiz(
            question = "What does case _ do?",
            options = listOf("Matches anything (like else)", "Stops the program", "Matches only 0", "Creates a variable"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_loops",
        title = "18. Loops",
        category = "Python",
        description = "Loops repeat code without us writing it again and again.\n\n" +
            "The for loop goes through a sequence of values, e.g. the numbers given by range(). " +
            "range(1, 4) gives the numbers 1, 2, 3 (the last limit is not included).\n\n" +
            "The while loop repeats as long as a condition is true. Make sure the condition eventually becomes false, otherwise the loop never ends.",
        codeExample = """
            # for loop
            for i in range(1, 4):
                print("Round", i)

            # while loop
            count = 3
            while count > 0:
                print(count)
                count = count - 1

            print("Here we go!")
        """.trimIndent(),
        quiz = Quiz(
            question = "How many times will this loop run: for i in range(5):",
            options = listOf("4", "5", "6", "Infinitely"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_range",
        title = "19. Range",
        category = "Python",
        description = "range() creates a sequence of numbers, mainly for use in for. It has three forms: range(stop), range(start, stop) and range(start, stop, step).\n\n" +
            "The stop value is never included. With a negative step you count backwards. With list(range(...)) you can see all the numbers.",
        codeExample = """
            print(list(range(5)))
            print(list(range(2, 6)))
            print(list(range(0, 10, 3)))
            print(list(range(5, 0, -1)))

            for i in range(3):
                print("i =", i)
        """.trimIndent(),
        quiz = Quiz(
            question = "Which numbers does range(2, 6) give?",
            options = listOf("2, 3, 4, 5", "2, 3, 4, 5, 6", "3, 4, 5, 6", "2, 6"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_functions",
        title = "20. Functions",
        category = "Python",
        description = "A function is a named piece of code that you can call as many times as you like. It is defined with def and can take parameters.\n\n" +
            "With return it gives back a result. You can give a parameter a default value and call the function using argument names.",
        codeExample = """
            def greet(name, greeting="Hello"):
                return greeting + ", " + name + "!"

            def add(a, b):
                return a + b

            print(greet("Maria"))
            print(greet("Nick", greeting="Good morning"))
            print(add(3, 4))
        """.trimIndent(),
        quiz = Quiz(
            question = "Which keyword defines a function?",
            options = listOf("function", "def", "func", "fun"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_arrays",
        title = "21. Arrays",
        category = "Python",
        description = "Python has no built-in array type; we use lists instead. Lists do everything that arrays do in other languages.\n\n" +
            "You can also have a list inside a list, which works like a two-dimensional array. The array module in the standard library exists for very specific cases with a single number type.",
        codeExample = """
            grid = [
                [1, 2, 3],
                [4, 5, 6],
            ]

            print(grid[1][2])      # row 1, column 2
            print(len(grid))

            for row in grid:
                print(row)

            print([x * 2 for x in grid[0]])
        """.trimIndent(),
        quiz = Quiz(
            question = "What do we usually use in Python instead of arrays?",
            options = listOf("Lists", "Tuples only", "Strings", "Booleans"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_iterators",
        title = "22. Iterators",
        category = "Python",
        description = "An iterator is an object that gives you the items of a collection one by one. Lists, tuples, strings and dictionaries are iterable, meaning you can get an iterator from them with iter().\n\n" +
            "next() returns the next item. When they run out, StopIteration is raised. The for loop does all this automatically.",
        codeExample = """
            fruits = ["apple", "banana", "cherry"]
            it = iter(fruits)

            print(next(it))
            print(next(it))
            print(next(it))

            # The for loop uses an iterator behind the scenes
            for letter in "Py":
                print(letter)
        """.trimIndent(),
        quiz = Quiz(
            question = "Which function returns the next item of an iterator?",
            options = listOf("next()", "iter()", "step()", "more()"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_modules",
        title = "23. Modules",
        category = "Python",
        description = "A module is a file with ready-made code (functions, variables) that you can use in your program with import.\n\n" +
            "Python comes with many ready-made modules, such as math, random, datetime and json. You can bring in only what you need with from ... import ... or give it a shorter name with as.",
        codeExample = """
            import random
            import math as m
            from statistics import mean

            print(random.randint(1, 6))
            print(m.sqrt(49))
            print(mean([2, 4, 6]))
        """.trimIndent(),
        quiz = Quiz(
            question = "Which statement brings a module into the program?",
            options = listOf("include", "import", "require", "using"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_dates",
        title = "24. Dates",
        category = "Python",
        description = "For dates and times we use the datetime module. datetime.now() gives the current moment.\n\n" +
            "With strftime() you format a date as text: %d day, %m month, %Y year, %H hour, %M minutes. With timedelta you add or subtract days.",
        codeExample = """
            from datetime import datetime, date, timedelta

            d = date(2026, 11, 9)
            print(d)
            print(d.strftime("%d/%m/%Y"))
            print(d + timedelta(days=30))

            now = datetime.now()
            print(type(now))
        """.trimIndent(),
        quiz = Quiz(
            question = "What does %Y mean in strftime()?",
            options = listOf("The year with 4 digits", "The month", "The hour", "The day"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_math",
        title = "25. Math",
        category = "Python",
        description = "Python has built-in functions such as min(), max(), abs(), round() and sum(). For more we use the math module.\n\n" +
            "math gives you sqrt() (square root), ceil() and floor() (rounding up and down), pi and many more.",
        codeExample = """
            import math

            print(min(3, 7, 1), max(3, 7, 1))
            print(abs(-5))
            print(round(3.14159, 2))
            print(math.sqrt(16))
            print(math.ceil(2.1), math.floor(2.9))
            print(math.pi)
        """.trimIndent(),
        quiz = Quiz(
            question = "What does math.ceil(2.1) return?",
            options = listOf("2", "3", "2.1", "1"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_json",
        title = "26. JSON",
        category = "Python",
        description = "JSON is a very widespread text format for exchanging data between programs and websites. It looks like Python dictionaries.\n\n" +
            "With the json module: json.loads() converts JSON text into a dictionary and json.dumps() converts a dictionary into JSON text.",
        codeExample = """
            import json

            text = '{"name": "Maria", "age": 25}'
            data = json.loads(text)
            print(data["name"])

            data["age"] = 26
            print(json.dumps(data, ensure_ascii=False))
        """.trimIndent(),
        quiz = Quiz(
            question = "Which function converts JSON text into a dictionary?",
            options = listOf("json.dumps()", "json.loads()", "json.print()", "json.make()"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_regex",
        title = "27. RegEx",
        category = "Python",
        description = "Regular expressions (RegEx) are patterns for searching text. In Python you use them with the re module.\n\n" +
            "Basic symbols: \\d digit, \\w letter or digit, + one or more, * zero or more, . any character. findall() finds all matches and sub() replaces them.",
        codeExample = """
            import re

            text = "Phone numbers: 6912345678 and 2101234567"

            print(re.findall(r"\d+", text))
            print(re.search(r"\d{10}", text).group())
            print(re.sub(r"\d", "*", "Code 1234"))
        """.trimIndent(),
        quiz = Quiz(
            question = "What does \\d match in a regular expression?",
            options = listOf("A digit", "A letter", "A space", "Anything"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_pip",
        title = "28. PIP",
        category = "Python",
        description = "PIP is Python's package manager. With it you download ready-made libraries built by the community, e.g. requests or numpy.\n\n" +
            "The commands are typed in your computer's terminal (not inside the program): pip install name, pip uninstall name, pip list. PIP does not run inside this app, but the example below shows how to check whether a library exists.",
        codeExample = """
            # In your computer's terminal you would type:
            #   pip install requests
            #   pip list

            import importlib.util

            for name in ["json", "random", "something_that_does_not_exist"]:
                found = importlib.util.find_spec(name) is not None
                print(name, "->", "exists" if found else "does not exist")
        """.trimIndent(),
        quiz = Quiz(
            question = "Which command installs a package with PIP?",
            options = listOf("pip install name", "pip add name", "python get name", "install pip name"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_try_except",
        title = "29. Try...Except",
        category = "Python",
        description = "When an error occurs, the program stops. With try...except you can “catch” the error and carry on smoothly.\n\n" +
            "The code that might fail goes in try, and except says what to do if it fails. else runs if there was no error and finally always runs.",
        codeExample = """
            try:
                number = int("abc")
            except ValueError:
                print("That's not a number!")
            else:
                print("All good:", number)
            finally:
                print("This always runs")

            try:
                print(10 / 0)
            except ZeroDivisionError:
                print("We don't divide by zero")
        """.trimIndent(),
        quiz = Quiz(
            question = "Which block ALWAYS runs, regardless of errors?",
            options = listOf("try", "except", "else", "finally"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "python_string_formatting",
        title = "30. String formatting",
        category = "Python",
        description = "f-strings are the easiest way to put values inside text. You write f before the quotes and put variables inside curly braces { }.\n\n" +
            "Inside the braces you can also write expressions and set a format: {x:.2f} gives 2 decimal places.",
        codeExample = """
            name = "Maria"
            price = 4.5
            qty = 3

            print(f"Hello {name}!")
            print(f"Total: {price * qty:.2f} euros")
            print(f"{qty} times {price} = {qty * price}")
            print(f"{1234567:,}")
        """.trimIndent(),
        quiz = Quiz(
            question = "What does f\"{3.14159:.2f}\" print?",
            options = listOf("3.14", "3.1", "3.14159", "3.142"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_none",
        title = "31. None",
        category = "Python",
        description = "None is a special value that means “nothing” or “no value”. It has its own type, NoneType.\n\n" +
            "A function without a return automatically returns None. To check whether something is None use is None, not ==.",
        codeExample = """
            result = None
            print(result)
            print(result is None)

            def say_hi():
                print("Hi!")

            value = say_hi()
            print(value)
            print(type(None))
        """.trimIndent(),
        quiz = Quiz(
            question = "What does a function without a return give back?",
            options = listOf("0", "None", "\"\"", "False"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_user_input",
        title = "32. User input",
        category = "Python",
        description = "With the input() function a program asks the user for text. The result is always a string, so for numbers you need int() or float().\n\n" +
            "input() is not supported inside this app, so the example uses ready-made values. On a computer you would write age = int(input(\"Age: \")).",
        codeExample = """
            # On a computer:  name = input("What's your name? ")
            name = "Maria"
            age_text = "25"            # input() always gives text

            age = int(age_text)        # convert to a number
            print(f"Hello {name}!")
            print("Next year you will be", age + 1)
        """.trimIndent(),
        quiz = Quiz(
            question = "What type is the value returned by input() always?",
            options = listOf("int", "float", "str", "bool"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "python_virtualenv",
        title = "33. Virtual Environment",
        category = "Python",
        description = "A virtual environment is a separate folder with its own Python version and its own packages for each project. This way projects don't get mixed up with each other.\n\n" +
            "In the terminal: python -m venv myenv to create it, source myenv/bin/activate to activate it (on Windows: myenv\\Scripts\\activate) and deactivate to leave it.",
        codeExample = """
            # In your computer's terminal:
            #   python -m venv myenv
            #   source myenv/bin/activate
            #   pip install requests
            #   deactivate

            import sys
            print("Python version:", sys.version.split()[0])
        """.trimIndent(),
        quiz = Quiz(
            question = "Which command creates a virtual environment?",
            options = listOf("python -m venv myenv", "pip venv myenv", "python new myenv", "venv install myenv"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_oop",
        title = "34. Object-Oriented Programming (OOP)",
        category = "Python",
        description = "Object-oriented programming (OOP) organizes code around “objects”, which combine data (properties) and actions (methods).\n\n" +
            "For example, a car has properties (color, speed) and methods (accelerate, brake). The main ideas of OOP are: classes, inheritance, polymorphism and encapsulation, which we will see in the next lessons. In Python everything is an object.",
        codeExample = """
            print(type("text"))
            print(type(5))
            print(type([1, 2]))

            # Methods belong to objects:
            print("python".upper())
            print([3, 1, 2].count(1))
        """.trimIndent(),
        quiz = Quiz(
            question = "What does an object combine?",
            options = listOf("Data and methods", "Only numbers", "Only functions", "Only text"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_classes_objects",
        title = "35. Classes and objects",
        category = "Python",
        description = "A class is the “blueprint” and an object is something built from that blueprint. We define a class with the word class and create an object by calling it like a function.\n\n" +
            "From one class you can create as many objects as you want, and each one has its own data.",
        codeExample = """
            class Dog:
                species = "dog"

            d1 = Dog()
            d2 = Dog()

            print(d1.species)
            print(type(d1))
            print(d1 is d2)
        """.trimIndent(),
        quiz = Quiz(
            question = "Which keyword defines a class?",
            options = listOf("object", "class", "def", "new"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "python_init",
        title = "36. The __init__ method",
        category = "Python",
        description = "__init__ is a special method that runs automatically every time you create a new object. We use it to give initial values to the properties.\n\n" +
            "The arguments you pass when you create the object go to __init__.",
        codeExample = """
            class Person:
                def __init__(self, name, age):
                    self.name = name
                    self.age = age

            p = Person("Maria", 25)
            print(p.name)
            print(p.age)
        """.trimIndent(),
        quiz = Quiz(
            question = "When does __init__ run?",
            options = listOf("When a new object is created", "When the program ends", "Only when you call it explicitly", "When the object is deleted"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_self",
        title = "37. The self parameter",
        category = "Python",
        description = "self refers to the object itself that calls the method. With it a method can read or change the object's properties.\n\n" +
            "It must be the first parameter of every method. When you call the method you don't write self; Python passes it by itself. The name self is a convention, but everybody uses it.",
        codeExample = """
            class Counter:
                def __init__(self):
                    self.value = 0

                def add(self):
                    self.value += 1

            a = Counter()
            b = Counter()
            a.add()
            a.add()
            b.add()
            print(a.value, b.value)
        """.trimIndent(),
        quiz = Quiz(
            question = "What does self refer to?",
            options = listOf("The object itself", "The parent class", "The program", "A global variable"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_class_properties",
        title = "38. Class properties",
        category = "Python",
        description = "Properties are variables that belong to an object. You read them with a dot: object.property, and you can change them, add new ones or delete them with del.\n\n" +
            "There are also class properties, which are defined directly inside the class and are shared by all objects.",
        codeExample = """
            class Car:
                wheels = 4                 # class property (shared)

                def __init__(self, brand):
                    self.brand = brand     # object property

            c = Car("Toyota")
            print(c.brand, c.wheels)

            c.brand = "Fiat"
            c.color = "red"               # new property
            print(c.brand, c.color)
            print(Car.wheels)
        """.trimIndent(),
        quiz = Quiz(
            question = "How do you read the brand property of the object c?",
            options = listOf("c.brand", "c[brand]", "c->brand", "brand(c)"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_class_methods",
        title = "39. Class methods",
        category = "Python",
        description = "Methods are functions defined inside a class that act on the object. Their first parameter is always self.\n\n" +
            "They can take other arguments and return values, just like plain functions.",
        codeExample = """
            class BankAccount:
                def __init__(self, balance=0):
                    self.balance = balance

                def deposit(self, amount):
                    self.balance += amount

                def withdraw(self, amount):
                    if amount > self.balance:
                        print("Not enough money")
                    else:
                        self.balance -= amount

            acc = BankAccount(100)
            acc.deposit(50)
            acc.withdraw(30)
            acc.withdraw(500)
            print(acc.balance)
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the first parameter of a class method?",
            options = listOf("self", "this", "class", "object"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_magic_methods",
        title = "40. Magic methods",
        category = "Python",
        description = "Magic methods (dunder methods) have a double underscore at the start and at the end, e.g. __str__, __len__, __add__. Python calls them by itself in specific situations.\n\n" +
            "__str__ defines how an object is printed with print(), __len__ what len() returns, and __add__ what the + operator does.",
        codeExample = """
            class Point:
                def __init__(self, x, y):
                    self.x = x
                    self.y = y

                def __str__(self):
                    return f"({self.x}, {self.y})"

                def __add__(self, other):
                    return Point(self.x + other.x, self.y + other.y)

            a = Point(1, 2)
            b = Point(3, 4)
            print(a)
            print(a + b)
        """.trimIndent(),
        quiz = Quiz(
            question = "Which magic method defines how an object is printed with print()?",
            options = listOf("__str__", "__print__", "__text__", "__show__"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_inheritance",
        title = "41. Inheritance",
        category = "Python",
        description = "Inheritance lets a class (the child) take the properties and methods of another (the parent), so you don't rewrite the same code.\n\n" +
            "You write the parent's name in parentheses: class Child(Parent). With super() you call the parent's methods, e.g. its __init__.",
        codeExample = """
            class Animal:
                def __init__(self, name):
                    self.name = name

                def eat(self):
                    print(self.name, "eats")

            class Dog(Animal):
                def __init__(self, name, breed):
                    super().__init__(name)
                    self.breed = breed

                def bark(self):
                    print(self.name, "barks")

            d = Dog("Rex", "Labrador")
            d.eat()      # inherited from Animal
            d.bark()
        """.trimIndent(),
        quiz = Quiz(
            question = "What does super() do?",
            options = listOf("Gives access to the parent class", "Deletes the class", "Creates a new object", "Ends the program"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_polymorphism",
        title = "42. Polymorphism",
        category = "Python",
        description = "Polymorphism means “many forms”: different classes can have a method with the same name that does something different in each one.\n\n" +
            "This way you can call the same method on different objects without knowing exactly what they are. A child class can also override a method of its parent.",
        codeExample = """
            class Dog:
                def speak(self):
                    return "Woof!"

            class Cat:
                def speak(self):
                    return "Meow!"

            class Cow:
                def speak(self):
                    return "Moo!"

            for animal in [Dog(), Cat(), Cow()]:
                print(animal.speak())
        """.trimIndent(),
        quiz = Quiz(
            question = "What does polymorphism allow?",
            options = listOf("The same method with different behavior per class", "A class to have only one object", "Methods to not be needed", "Code to run faster"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_encapsulation",
        title = "43. Encapsulation",
        category = "Python",
        description = "Encapsulation means we hide a class's internal data so that it can only change through controlled methods.\n\n" +
            "In Python, a name starting with _ means “internal, don't touch it”, while with __ (two underscores) Python hides it further and you cannot access it directly from outside.",
        codeExample = """
            class Wallet:
                def __init__(self):
                    self.__money = 0          # private property

                def add(self, amount):
                    if amount > 0:
                        self.__money += amount

                def get_money(self):
                    return self.__money

            w = Wallet()
            w.add(50)
            w.add(-20)                        # rejected
            print(w.get_money())

            try:
                print(w.__money)
            except AttributeError:
                print("You have no direct access!")
        """.trimIndent(),
        quiz = Quiz(
            question = "How is a private property declared in Python?",
            options = listOf("With two underscores at the start, e.g. __money", "With the word private", "With an asterisk *", "With the word hidden"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "python_inner_classes",
        title = "44. Inner classes",
        category = "Python",
        description = "An inner class is a class defined inside another class. It is useful when a class only makes sense within the context of the other.\n\n" +
            "For example, a Car can have an Engine class inside it. You create the inner object inside the __init__ of the outer class.",
        codeExample = """
            class Car:
                def __init__(self, brand):
                    self.brand = brand
                    self.engine = self.Engine(120)

                class Engine:
                    def __init__(self, horsepower):
                        self.horsepower = horsepower

                    def describe(self):
                        return f"Engine with {self.horsepower} horsepower"

            c = Car("Fiat")
            print(c.brand)
            print(c.engine.describe())
        """.trimIndent(),
        quiz = Quiz(
            question = "What is an inner class?",
            options = listOf("A class defined inside another class", "A class without methods", "A class that cannot have objects", "A class from another file"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "linux_intro",
        title = "1. What is Linux",
        category = "Linux",
        description = "Linux is an open-source operating system, like Windows and macOS. It runs most of the world's servers, Android phones and many computers.\n\n" +
            "With Linux we often work in the terminal: a window where you type commands and press Enter. The program that reads your commands is called the shell (usually bash).\n\n" +
            "echo prints text, whoami shows your username and uname shows the name of the system.",
        codeExample = """
            echo "Hello, Linux!"
            whoami
            uname
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the terminal?",
            options = listOf("A window where you type commands", "A photo editing program", "A file type", "An antivirus"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Hello, Linux!
            maria
            Linux
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_pwd",
        title = "2. Where am I (pwd)",
        category = "Linux",
        description = "The terminal is always \"inside\" a folder. The pwd command (print working directory) shows the path of the folder you are in right now.\n\n" +
            "The path starts at the root / and each folder is separated by /. Your personal folder (home) is usually /home/name.",
        codeExample = """
            echo "I am here:"
            pwd
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the pwd command do?",
            options = listOf("It shows the folder you are in", "It changes your password", "It creates a folder", "It clears the screen"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            I am here:
            /home/maria
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_ls",
        title = "3. Listing files (ls)",
        category = "Linux",
        description = "The ls command shows what the current folder contains. Options change how it behaves and are written after a dash.\n\n" +
            "-l shows a detailed list (permissions, size, date) and -a also shows hidden files, which are the ones whose name starts with a dot.",
        codeExample = """
            ls
            ls -l
            ls -a
        """.trimIndent(),
        quiz = Quiz(
            question = "Which command also shows hidden files?",
            options = listOf("ls -a", "ls -l", "ls -r", "ls -t"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Documents  Downloads  notes.txt
            total 12
            drwxr-xr-x 2 maria maria 4096 Nov 10 09:15 Documents
            drwxr-xr-x 2 maria maria 4096 Nov 10 09:16 Downloads
            -rw-r--r-- 1 maria maria   42 Nov 10 09:20 notes.txt
            .  ..  .bashrc  Documents  Downloads  notes.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_cd",
        title = "4. Changing folder (cd)",
        category = "Linux",
        description = "The cd command (change directory) moves you to another folder. You write the folder name after the command.\n\n" +
            ".. means \"one folder up\", . means \"the current folder\" and ~ is your personal folder (home). cd with nothing after it also takes you home.",
        codeExample = """
            pwd
            cd Documents
            pwd
            cd ..
            pwd
            cd ~
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the command cd .. do?",
            options = listOf("It moves you one folder up", "It takes you home", "It creates a folder named ..", "It deletes the current folder"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            /home/maria
            /home/maria/Documents
            /home/maria
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_mkdir",
        title = "5. Creating folders (mkdir)",
        category = "Linux",
        description = "mkdir (make directory) creates a new folder. You can give more than one name in the same command.\n\n" +
            "The -p option also creates the missing folders in between, e.g. mkdir -p a/b/c creates all three levels at once.",
        codeExample = """
            mkdir projects
            mkdir -p projects/linux/notes
            ls projects
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the -p option do in mkdir?",
            options = listOf("It also creates the folders in between", "It protects the folder with a password", "It prints the folder name", "It creates a file instead of a folder"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            linux
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_touch",
        title = "6. Creating files (touch)",
        category = "Linux",
        description = "touch creates a new, empty file. If the file already exists it does not erase its content, it only updates its modification time.\n\n" +
            "You can create many files with one command by separating the names with a space.",
        codeExample = """
            mkdir practice
            cd practice
            touch hello.txt
            touch a.txt b.txt
            ls
        """.trimIndent(),
        quiz = Quiz(
            question = "What does touch do when the file already exists?",
            options = listOf("It keeps the content and only updates the modification time", "It deletes the file", "It copies the file", "It always gives an error"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            a.txt  b.txt  hello.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_redirect",
        title = "7. Output redirection (> and >>)",
        category = "Linux",
        description = "Normally the output of a command appears on the screen. With > we send it to a file instead. If the file already exists, its content is replaced.\n\n" +
            "With >> the output is added to the end of the file, and the old content stays. To see the file we use cat, which you will learn in the next lesson.",
        codeExample = """
            echo "Hello" > hello.txt
            echo "Linux" >> hello.txt
            cat hello.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the difference between >> and >?",
            options = listOf("It adds to the end of the file instead of replacing it", "There is no difference", "It deletes the file", "It sends the output to the screen"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Hello
            Linux
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_cat",
        title = "8. Viewing files (cat)",
        category = "Linux",
        description = "cat shows the content of a file on the screen. It is ideal for small files. If you give more than one file, it shows them one after the other.\n\n" +
            "With the -n option it numbers the lines. For big files there is also less, where you move with the arrows and quit with q.",
        codeExample = """
            echo "line 1" > notes.txt
            echo "line 2" >> notes.txt
            cat notes.txt
            cat -n notes.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the command cat file.txt do?",
            options = listOf("It shows the content of the file", "It deletes the file", "It creates a folder", "It renames the file"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            line 1
            line 2
                 1	line 1
                 2	line 2
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_cp",
        title = "9. Copying (cp)",
        category = "Linux",
        description = "cp copies files: cp source destination. The first name is the existing file and the second is the new copy or the folder where it will go.\n\n" +
            "To copy a whole folder with everything inside it you need the -r (recursive) option.",
        codeExample = """
            echo "data" > a.txt
            cp a.txt b.txt
            mkdir folder
            cp a.txt folder/
            cp -r folder folder2
            ls
            ls folder2
        """.trimIndent(),
        quiz = Quiz(
            question = "Which command copies a folder with its content?",
            options = listOf("cp -r", "cp -n", "cp -v", "cp -i"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            a.txt  b.txt  folder  folder2
            a.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_mv",
        title = "10. Moving and renaming (mv)",
        category = "Linux",
        description = "mv moves files and folders: mv source destination. If the destination is a folder, the file goes inside it.\n\n" +
            "The same command also renames: in Linux, renaming is simply moving with a new name.",
        codeExample = """
            touch old.txt
            mv old.txt new.txt
            mkdir docs
            mv new.txt docs/
            ls
            ls docs
        """.trimIndent(),
        quiz = Quiz(
            question = "How do you rename a file in Linux?",
            options = listOf("mv old.txt new.txt", "ren old.txt new.txt", "name old.txt new.txt", "touch old.txt new.txt"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            docs
            new.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_rm",
        title = "11. Deleting (rm and rmdir)",
        category = "Linux",
        description = "rm deletes files. Be careful: the terminal has no recycle bin, so whatever you delete is gone for good.\n\n" +
            "rmdir deletes only empty folders. For a folder with content use rm -r. Be extra careful with rm -r and always check the name before pressing Enter.",
        codeExample = """
            touch a.txt b.txt
            mkdir old
            rm a.txt
            rmdir old
            mkdir -p full/inside
            rm -r full
            ls
        """.trimIndent(),
        quiz = Quiz(
            question = "Which command deletes a folder that has files inside?",
            options = listOf("rm -r folder", "rmdir folder", "rm folder", "delete folder"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            b.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_headtail",
        title = "12. Start and end of a file (head, tail)",
        category = "Linux",
        description = "head shows the first lines of a file and tail shows the last ones. By default they show 10 lines, and the -n option changes the number.\n\n" +
            "tail is very useful for log files, where the most recent event is at the end. The command seq 1 10 prints the numbers from 1 to 10 and we use it here to build a test file.",
        codeExample = """
            seq 1 10 > numbers.txt
            head -n 3 numbers.txt
            tail -n 3 numbers.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "Which command shows the last 3 lines of a file?",
            options = listOf("tail -n 3 numbers.txt", "head -n 3 numbers.txt", "cat -n 3 numbers.txt", "last 3 numbers.txt"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            1
            2
            3
            8
            9
            10
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_wc",
        title = "13. Counting (wc)",
        category = "Linux",
        description = "wc (word count) counts the lines, words and bytes of a file. Without options it prints all three numbers in that order.\n\n" +
            "With -l you count only lines, with -w only words and with -c only bytes.",
        codeExample = """
            seq 1 10 > numbers.txt
            wc -l numbers.txt
            wc -w numbers.txt
            wc numbers.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "Which wc option counts only the lines?",
            options = listOf("-l", "-w", "-c", "-m"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            10 numbers.txt
            10 numbers.txt
             10  10  21 numbers.txt
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_grep",
        title = "14. Searching text (grep)",
        category = "Linux",
        description = "grep searches inside files and prints only the lines that contain the text you ask for: grep text file.\n\n" +
            "Main options: -i ignores upper and lower case, -n shows the line number, -c counts how many lines match and -r searches inside all folders.",
        codeExample = """
            echo "apple" > fruits.txt
            echo "banana" >> fruits.txt
            echo "apple pie" >> fruits.txt
            grep apple fruits.txt
            grep -n banana fruits.txt
            grep -i APPLE fruits.txt
            grep -c apple fruits.txt
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the -i option do in grep?",
            options = listOf("It ignores the difference between upper and lower case", "It shows line numbers", "It deletes the matching lines", "It searches inside folders"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            apple
            apple pie
            2:banana
            apple
            apple pie
            2
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_pipe",
        title = "15. Pipes (|)",
        category = "Linux",
        description = "The | character (pipe) sends the output of one command as input to the next one. This way you combine small commands to do bigger jobs.\n\n" +
            "Example: ls | wc -l counts how many files the folder has, because wc -l takes the list from ls as its input.",
        codeExample = """
            mkdir demo
            cd demo
            seq 1 20 > numbers.txt
            head -n 3 numbers.txt | tail -n 1
            ls | wc -l
            cat numbers.txt | grep 1 | wc -l
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the | character do between two commands?",
            options = listOf("It sends the output of the first as input to the second", "It runs only the second command", "It writes the output to a file", "It deletes the output of the first one"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            3
            1
            11
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_find",
        title = "16. Finding files (find)",
        category = "Linux",
        description = "find searches for files and folders inside a path: find path criteria. The order of the results may differ from one system to another.\n\n" +
            "With -name you search by name (the asterisk * stands for any text) and with -type f or -type d you limit the result to files or folders respectively.",
        codeExample = """
            mkdir -p project/src
            touch project/readme.txt project/src/main.py project/src/util.py
            find project -name "*.py"
            find project -type d
            find project -type f
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the command find . -name \"*.txt\" find?",
            options = listOf("All files ending in .txt", "Only folders named txt", "Files that contain the word txt", "Nothing, it is a wrong command"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            project/src/main.py
            project/src/util.py
            project
            project/src
            project/readme.txt
            project/src/main.py
            project/src/util.py
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_help",
        title = "17. Getting help (--help and man)",
        category = "Linux",
        description = "You don't need to remember every option. Most commands accept --help and print a short help text.\n\n" +
            "man (manual) opens the full manual of a command. You move with the arrows, search with / and quit with q. whatis gives a one-line description.",
        codeExample = """
            ls --help
            whatis ls
            man ls
        """.trimIndent(),
        quiz = Quiz(
            question = "How do you leave the man page?",
            options = listOf("By pressing q", "By pressing x", "By pressing Enter", "By pressing Space"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            Usage: ls [OPTION]... [FILE]...
            List information about the FILEs (the current directory by default).
            ...
            ls (1)               - list directory contents
            (man opens the manual, press q to quit)
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_chmod",
        title = "18. Permissions (chmod)",
        category = "Linux",
        description = "Every file has permissions for three categories: the owner, the group and others. Each can have r (read), w (write) and x (execute). You see them with ls -l, e.g. -rw-r--r--.\n\n" +
            "chmod changes the permissions. chmod +x makes a file executable. With numbers: r=4, w=2, x=1, so 600 means read and write for the owner only.",
        codeExample = """
            touch script.sh
            ls -l script.sh
            chmod +x script.sh
            ls -l script.sh
            chmod 600 script.sh
            ls -l script.sh
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the command chmod +x script.sh do?",
            options = listOf("It makes the file executable", "It deletes the file", "It copies the file", "It hides the file"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            -rw-r--r-- 1 maria maria 0 Nov 10 10:00 script.sh
            -rwxr-xr-x 1 maria maria 0 Nov 10 10:00 script.sh
            -rw------- 1 maria maria 0 Nov 10 10:00 script.sh
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_sudo",
        title = "19. Administrator (sudo)",
        category = "Linux",
        description = "The root user is the administrator of the system and can do everything. For safety we don't work as root all the time: when needed, we put the word sudo in front of the command and type our password.\n\n" +
            "sudo is needed, for example, to install programs. On Debian and Ubuntu we use apt: sudo apt update refreshes the list of available programs. Other distributions have other package managers (dnf, pacman).",
        codeExample = """
            whoami
            sudo whoami
            sudo apt update
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the word sudo do in front of a command?",
            options = listOf("It runs the command with administrator rights", "It deletes the command", "It runs the command in the background", "It runs the command twice"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
            maria
            [sudo] password for maria:
            root
            Hit:1 http://archive.ubuntu.com/ubuntu noble InRelease
            Reading package lists... Done
            Building dependency tree... Done
        """.trimIndent(),
    ),
    Lesson(
        id = "linux_shortcuts",
        title = "20. Shortcuts and history",
        category = "Linux",
        description = "The terminal has tools that save time. The Tab key completes a file or command name automatically and the up arrow brings back previous commands.\n\n" +
            "history shows the commands you have typed. Ctrl+C stops a running command and Ctrl+L (or the clear command) clears the screen. date shows the date and time.",
        codeExample = """
            history | tail -n 3
            date
            clear
        """.trimIndent(),
        quiz = Quiz(
            question = "Which shortcut stops a running command?",
            options = listOf("Ctrl+C", "Ctrl+V", "Ctrl+L", "Tab"),
            correctOptionIndex = 0,
        ),
        sampleOutput = """
               98  pwd
               99  ls -l
              100  history | tail -n 3
            Tue Nov 10 10:30:00 UTC 2026
            (clear wipes the screen)
        """.trimIndent(),
    ),
    Lesson(
        id = "html_intro",
        title = "1. What is HTML",
        category = "HTML",
        description = "HTML (HyperText Markup Language) is the language web pages are made with. It is not a programming language: it describes the structure of the page, that is, which part is a title, which is a paragraph, which is an image.\n\n" +
            "HTML is made of tags inside angle brackets, e.g. <p>. Most tags have a start and an end: <p> opens and </p> closes. Everything together, with the content, is called an element. Press \"Preview\" to see the result.",
        codeExample = """
            <h1>Hello, HTML!</h1>
            <p>This is my first page.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "What does HTML describe?",
            options = listOf("The structure of a web page", "The logic of a program", "The database of a site", "How the server works"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_editors",
        title = "2. Editors",
        category = "HTML",
        description = "An HTML page is just a plain text file. All you need to write one is a text editor such as Notepad, or a code editor such as VS Code, which colours your code and helps with autocompletion.\n\n" +
            "You save the file with the .html extension and open it in a browser by double-clicking it. When you change the code, you save and refresh the page to see the change.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <title>index.html</title>
            </head>
            <body>
              <h1>My first file</h1>
              <p>Saved as index.html</p>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which extension is used to save an HTML file?",
            options = listOf(".html", ".txt", ".exe", ".doc"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_structure",
        title = "3. The structure of a page",
        category = "HTML",
        description = "Every HTML page has the same basic structure. <!DOCTYPE html> says this is modern HTML and <html> contains the whole page.\n\n" +
            "Inside <head> go the details that are not shown on the page, like the <title> that appears in the browser tab. Inside <body> goes everything the user sees.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <title>My page</title>
            </head>
            <body>
              <h1>Welcome!</h1>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Where does the content the user sees go?",
            options = listOf("Inside <body>", "Inside <head>", "Inside <title>", "Inside <!DOCTYPE>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_elements",
        title = "4. Elements",
        category = "HTML",
        description = "An HTML element consists of a start tag, the content and an end tag, e.g. <p>Text</p>. Elements can be nested inside each other, like a <b> inside a <p>.\n\n" +
            "There are also empty elements, such as <br> and <hr>, which have no content and no end tag.",
        codeExample = """
            <p>This is a <b>paragraph</b> with a nested element.</p>
            <p>Line one<br>Line two</p>
            <hr>
            <p>br and hr are empty elements.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which of the following is an empty element?",
            options = listOf("<p>", "<br>", "<h1>", "<div>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_attributes",
        title = "5. Attributes",
        category = "HTML",
        description = "Attributes give extra information to a tag. They are written inside the opening tag, in the form name=\"value\".\n\n" +
            "Common attributes: id (a unique name for an element), class (a group name that can be repeated) and title (text shown when you hover with the mouse). An id must be unique in the whole page.",
        codeExample = """
            <p id="intro" class="note" title="A note">This paragraph has three attributes.</p>
            <p class="note">This one has the same class.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute must have a unique value in the whole page?",
            options = listOf("id", "class", "title", "style"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_headings",
        title = "6. Headings",
        category = "HTML",
        description = "Headings define titles. There are six levels, from <h1> (the biggest and most important) to <h6> (the smallest).\n\n" +
            "Use one <h1> per page for the main title and the other levels for subtitles. You pick them for their meaning, not for their size.",
        codeExample = """
            <h1>Main title</h1>
            <h2>Subtitle</h2>
            <h3>Smaller subtitle</h3>
            <h6>The smallest title</h6>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which is the biggest heading?",
            options = listOf("<h1>", "<h6>", "<head>", "<title>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_paragraphs",
        title = "7. Paragraphs and line breaks",
        category = "HTML",
        description = "<p> defines a paragraph. The browser ignores extra spaces and line breaks inside the code, so you need tags to control them.\n\n" +
            "<br> makes a line break inside a paragraph and <hr> adds a horizontal line. These two have no closing tag.",
        codeExample = """
            <p>First paragraph.</p>
            <p>First line<br>Second line</p>
            <hr>
            <p>Last paragraph.</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag makes a line break inside a paragraph?",
            options = listOf("<br>", "<hr>", "<p>", "<line>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_styles",
        title = "8. The style attribute",
        category = "HTML",
        description = "The style attribute changes how an element looks. You write property: value pairs separated by semicolons (;).\n\n" +
            "Useful properties: color (text colour), background-color, font-size, font-family and text-align.",
        codeExample = """
            <h1 style="color: blue;">Blue heading</h1>
            <p style="color: white; background-color: purple;">White text on purple</p>
            <p style="font-size: 24px; text-align: center;">Big centred text</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which CSS property changes the background colour?",
            options = listOf("color", "font-size", "background-color", "text-align"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_formatting",
        title = "9. Text formatting",
        category = "HTML",
        description = "Inside a paragraph you can add emphasis. <strong> makes text bold and marks it as important, <em> makes it italic and <mark> highlights it with a yellow background.\n\n" +
            "Tags can be placed inside each other, as long as they close in the opposite order from the one they opened.",
        codeExample = """
            <p>This is <strong>important</strong>.</p>
            <p>This has <em>emphasis</em>.</p>
            <p>This is <mark>highlighted</mark>.</p>
            <p><strong><em>Both together</em></strong></p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag makes text bold and important?",
            options = listOf("<strong>", "<em>", "<mark>", "<small>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_quotations",
        title = "10. Quotations (blockquote, q, abbr)",
        category = "HTML",
        description = "<q> puts a short quotation inside the text, and the browser adds quotation marks. <blockquote> shows a long quotation as a separate indented block.\n\n" +
            "<abbr> marks an abbreviation and its title attribute gives the full wording. <address> is used for contact details and <cite> for the title of a work.",
        codeExample = """
            <p>He said <q>learning is fun</q> yesterday.</p>
            <blockquote>A long quotation is shown as an indented block.</blockquote>
            <p><abbr title="HyperText Markup Language">HTML</abbr> is great.</p>
            <address>Jane Doe<br>Athens, Greece</address>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag shows a long quotation as an indented block?",
            options = listOf("<q>", "<abbr>", "<cite>", "<blockquote>"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_comments",
        title = "11. Comments and special characters",
        category = "HTML",
        description = "Comments are written between <!-- and --> and the browser doesn't show them. They are useful for notes inside the code.\n\n" +
            "The characters < and > belong to the syntax, so to show them you write &lt; and &gt;. &amp; gives & and &copy; gives the symbol ©.",
        codeExample = """
            <!-- This comment is not visible -->
            <p>To write a tag use &lt;p&gt;.</p>
            <p>Tom &amp; Jerry</p>
            <p>&copy; 2026 My page</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "How do you write a comment in HTML?",
            options = listOf("<!-- comment -->", "// comment", "# comment", "/* comment */"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_colors",
        title = "12. Colors",
        category = "HTML",
        description = "In HTML and CSS colours can be set in several ways: by name (red, tomato), by HEX code (#ff0000), by RGB (rgb(255, 0, 0)) and by HSL (hsl(0, 100%, 50%)).\n\n" +
            "A HEX code starts with # and has three pairs of digits for red, green and blue. You can apply colours to backgrounds, text or borders.",
        codeExample = """
            <p style="background-color: tomato;">Name: tomato</p>
            <p style="background-color: #4caf50;">HEX: #4caf50</p>
            <p style="background-color: rgb(255, 193, 7);">RGB: rgb(255, 193, 7)</p>
            <p style="background-color: hsl(210, 80%, 60%);">HSL: hsl(210, 80%, 60%)</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which is a valid HEX colour?",
            options = listOf("#ff0000", "ff0000#", "#gg0000", "hex(255,0,0)"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_css",
        title = "13. Colours and style (CSS)",
        category = "HTML",
        description = "CSS is the language that defines the appearance. The simplest way is the style attribute inside a tag, e.g. style=\"color: red\".\n\n" +
            "A rule has a property and a value, and many rules are separated with a semicolon: color (text colour), background-color (background), font-size (size of the font). For the whole page you add a <style> with rules for tags, e.g. p { color: green; }.",
        codeExample = """
            <style>
              p { color: green; }
            </style>
            <h1 style="color: blue">Blue title</h1>
            <p>Green paragraph</p>
            <p style="background-color: yellow; font-size: 22px">Yellow background</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which CSS property changes the text colour?",
            options = listOf("color", "background-color", "font-size", "text-style"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_links",
        title = "14. Links (a)",
        category = "HTML",
        description = "<a> (anchor) creates a link. The href attribute says where the link goes and the text between the tags is what the user taps.\n\n" +
            "href can point to another website (https://...), another file or a spot on the same page. The app has no internet, so links don't open in the preview.",
        codeExample = """
            <p>Visit <a href="https://www.wikipedia.org">Wikipedia</a>.</p>
            <p><a href="https://www.mozilla.org">A second link</a></p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute says where a link goes?",
            options = listOf("href", "src", "alt", "title"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_images",
        title = "15. Images (img)",
        category = "HTML",
        description = "<img> shows an image. It has no closing tag and needs two attributes: src (the path of the file) and alt (alternative text, read by screen readers and shown if the image fails to load).\n\n" +
            "You can set a size with width and height. In the preview there is no real image file, so you will only see the alt text.",
        codeExample = """
            <img src="cat.jpg" alt="A cat" width="200">
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the alt attribute for?",
            options = listOf("It shows alternative text when the image is not visible", "It sets the size of the image", "It sets the path of the file", "It changes the colour of the image"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_favicon",
        title = "16. Favicon",
        category = "HTML",
        description = "The favicon is the small icon shown on the browser tab, next to the title. You set it with a <link rel=\"icon\"> inside the <head>.\n\n" +
            "href points to the image file (usually .ico or .png). The preview has no tab, so the icon is not visible, but the code is exactly what you would use.",
        codeExample = """
            <head>
              <title>My page</title>
              <link rel="icon" type="image/png" href="favicon.png">
            </head>
            <body>
              <p>Look at the browser tab: the tiny icon is the favicon.</p>
            </body>
        """.trimIndent(),
        quiz = Quiz(
            question = "Where does the favicon tag go?",
            options = listOf("Inside the <body>", "Inside the <head>", "Inside the <footer>", "Inside the <title>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_title",
        title = "17. Page Title",
        category = "HTML",
        description = "<title> goes inside the <head> and sets the title of the page. It appears in the browser tab, in bookmarks and as the title in search results.\n\n" +
            "Do not confuse it with <h1>: <h1> is the visible heading inside the page, while <title> shows outside it. Every page should have a descriptive title.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <title>My first page - Codify</title>
            </head>
            <body>
              <h1>Visible heading</h1>
              <p>The title shows in the browser tab, not here.</p>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Where is the text of <title> displayed?",
            options = listOf("As a heading in the page", "In the footer", "In the browser tab", "Inside an image"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_tables",
        title = "18. Tables (table)",
        category = "HTML",
        description = "A table is made with <table>. Each row is a <tr> (table row). Inside a row, <th> are header cells (bold and centred) and <td> are the regular data cells.\n\n" +
            "The browser doesn't add a border by itself: border=\"1\" on <table> adds one quickly.",
        codeExample = """
            <table border="1">
              <tr>
                <th>Name</th>
                <th>Age</th>
              </tr>
              <tr>
                <td>Maria</td>
                <td>25</td>
              </tr>
              <tr>
                <td>Nick</td>
                <td>30</td>
              </tr>
            </table>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag defines a table row?",
            options = listOf("<tr>", "<td>", "<th>", "<row>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_lists",
        title = "19. Lists (ul, ol)",
        category = "HTML",
        description = "Lists organise items. <ul> (unordered list) makes a bulleted list and <ol> (ordered list) makes a numbered list. Each item goes inside an <li> (list item).\n\n" +
            "<li> always goes inside <ul> or <ol>. You can also put a list inside a list item to make sub-lists.",
        codeExample = """
            <ul>
              <li>Apples</li>
              <li>Bananas</li>
            </ul>
            <ol>
              <li>Open the editor</li>
              <li>Write HTML</li>
              <li>See the result</li>
            </ol>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag makes a numbered list?",
            options = listOf("<ol>", "<ul>", "<li>", "<dl>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_blockinline",
        title = "20. Block and Inline",
        category = "HTML",
        description = "Block elements (div, p, h1, ul) start on a new line and take the full available width. Inline elements (span, a, b, img) take only the space they need and stay on the same line as the text.\n\n" +
            "With CSS you can change this behaviour using the display property, e.g. display: inline or display: block.",
        codeExample = """
            <div style="background: lightblue;">Block 1 (div)</div>
            <div style="background: lightgreen;">Block 2 (div)</div>
            <span style="background: khaki;">Inline 1</span>
            <span style="background: pink;">Inline 2</span>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which of the following is an inline element?",
            options = listOf("<div>", "<p>", "<h1>", "<span>"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_divspan",
        title = "21. Grouping (div and span)",
        category = "HTML",
        description = "<div> is a \"box\" that groups elements and takes the whole line (block). <span> groups a piece of text inside a line (inline).\n\n" +
            "On their own they don't change the look, but we use them together with attributes and CSS to style a group of elements.",
        codeExample = """
            <div style="border: 2px solid blue; padding: 10px">
              <p>I am inside a div.</p>
              <p>This word is <span style="color: red">red</span>.</p>
            </div>
        """.trimIndent(),
        quiz = Quiz(
            question = "What is the difference between span and div?",
            options = listOf("span groups text inside a line, while div takes the whole line", "There is no difference", "span makes a table", "div is only for images"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_classes",
        title = "22. Classes",
        category = "HTML",
        description = "The class attribute gives elements a shared name, so you can apply the same style to them. In CSS you select a class by writing a dot before the name, e.g. .note.\n\n" +
            "An element can have several classes separated by spaces, and many elements can share the same class.",
        codeExample = """
            <style>
              .note { color: white; background: teal; padding: 8px; }
              .big { font-size: 24px; }
            </style>
            <p class="note">A note</p>
            <p class="note big">A big note</p>
            <p>A normal paragraph</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "How do you select the class \"note\" in CSS?",
            options = listOf(".note", "#note", "note", "*note"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_id",
        title = "23. Id",
        category = "HTML",
        description = "The id attribute gives an element a unique name. A page must not contain two elements with the same id. In CSS you select it with #, e.g. #title.\n\n" +
            "An id is also used for links to a specific place on the page (href=\"#bottom\") and for JavaScript to find the element.",
        codeExample = """
            <style>
              #main-title { color: crimson; }
            </style>
            <h1 id="main-title">A unique title</h1>
            <p><a href="#bottom">Jump to the bottom</a></p>
            <p id="bottom">Bottom paragraph (id="bottom")</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "What is true about id?",
            options = listOf("Many elements can share it", "It must be unique in the page", "It is written with a dot in CSS", "It can only be used on images"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_buttons",
        title = "24. Buttons",
        category = "HTML",
        description = "<button> makes a clickable button. The type attribute sets its action: submit (sends the form), button (does nothing on its own) or reset.\n\n" +
            "You can style it with CSS (colour, corners, padding) and turn it off with the disabled attribute. You often give it an action using JavaScript.",
        codeExample = """
            <button>Default</button>
            <button type="button" style="background: seagreen; color: white; padding: 8px 16px; border: none; border-radius: 8px;">Styled</button>
            <button disabled>Disabled</button>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute turns a button off?",
            options = listOf("off", "hidden", "disabled", "readonly"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_iframes",
        title = "25. Iframes",
        category = "HTML",
        description = "<iframe> embeds another web page inside your own. You set the address with src, the size with width and height and a description with title.\n\n" +
            "Here we use the srcdoc attribute, which puts the content directly in the code, so the example works without an internet connection.",
        codeExample = """
            <iframe
              srcdoc="<h2>Inside the iframe</h2><p>A page inside a page.</p>"
              width="300" height="140" title="Demo"></iframe>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag embeds another page?",
            options = listOf("<embed-page>", "<include>", "<frame-set>", "<iframe>"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_javascript",
        title = "26. JavaScript",
        category = "HTML",
        description = "JavaScript makes pages interactive. Its code goes inside <script>. It can find an element by its id (getElementById) and change its content.\n\n" +
            "With attributes such as onclick you run code when the user clicks an element. Press the button in the preview.",
        codeExample = """
            <p id="demo">Press the button.</p>
            <button onclick="sayHi()">Click me</button>
            <script>
              function sayHi() {
                document.getElementById("demo").textContent = "Hello from JavaScript!";
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Inside which tag does JavaScript code go?",
            options = listOf("<script>", "<js>", "<code>", "<javascript>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_filepaths",
        title = "27. File Paths",
        category = "HTML",
        description = "A path tells the browser where a file, such as an image, is located. If it is in the same folder you write just the name (pic.jpg), if it is in a subfolder you write images/pic.jpg and if it is one level up you write ../pic.jpg.\n\n" +
            "A full address (https://example.com/pic.jpg) is called an absolute path. The preview has no files, so you will only see the alt text.",
        codeExample = """
            <img src="pic.jpg" alt="Same folder">
            <img src="images/pic.jpg" alt="Inside the images folder">
            <img src="../pic.jpg" alt="One folder up">
        """.trimIndent(),
        quiz = Quiz(
            question = "What does ../ mean in a path?",
            options = listOf("The folder inside the current one", "One folder up", "The home page of the site", "Delete the file"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_head",
        title = "28. The Head",
        category = "HTML",
        description = "The <head> holds information about the page that is not displayed in its body. It contains <title>, <meta> (e.g. encoding, description, viewport), <style> and <link> tags pointing to CSS files or icons.\n\n" +
            "The only thing you see from the head is the title in the tab. All visible content goes in the <body>.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="UTF-8">
              <meta name="viewport" content="width=device-width, initial-scale=1">
              <meta name="description" content="A short page description">
              <title>Head demo</title>
              <style>body { font-family: sans-serif; }</style>
            </head>
            <body>
              <h1>Only the body is visible</h1>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which element does NOT normally go inside <head>?",
            options = listOf("<title>", "<meta>", "<p>", "<style>"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_layout",
        title = "29. Layout",
        category = "HTML",
        description = "A page is usually divided into a header, a menu, the main content and a footer. Semantic tags give meaning to each area and CSS positions them.\n\n" +
            "The easiest tool is flexbox: with display: flex the children of an element sit side by side and flex sets how much width each one gets.",
        codeExample = """
            <style>
              header, footer { background: #333; color: white; padding: 8px; text-align: center; }
              .wrap { display: flex; gap: 8px; margin: 8px 0; }
              .menu { flex: 1; background: #ddd; padding: 8px; }
              .content { flex: 3; background: #eee; padding: 8px; }
            </style>
            <header>Header</header>
            <div class="wrap">
              <nav class="menu">Menu</nav>
              <main class="content">Content</main>
            </div>
            <footer>Footer</footer>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which CSS declaration puts elements side by side with flexbox?",
            options = listOf("float: none;", "position: flex;", "layout: row;", "display: flex;"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_responsive",
        title = "30. Responsive Web Design",
        category = "HTML",
        description = "A responsive page adapts to every screen, from phone to desktop. The first step is the viewport meta tag inside <head>. The second is to avoid fixed widths: use max-width: 100% for images and grid or flex for layout.\n\n" +
            "Here the grid with repeat(auto-fit, minmax(120px, 1fr)) creates as many columns as fit. Narrow or rotate the screen to see the changes.",
        codeExample = """
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <style>
              .grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(120px, 1fr)); gap: 8px; }
              .box { background: #4db6ac; padding: 16px; text-align: center; }
              img { max-width: 100%; }
            </style>
            <div class="grid">
              <div class="box">1</div>
              <div class="box">2</div>
              <div class="box">3</div>
              <div class="box">4</div>
            </div>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which meta tag helps a page adapt to phones?",
            options = listOf("viewport", "charset", "description", "author"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_computercode",
        title = "31. Computer Code",
        category = "HTML",
        description = "HTML has special tags for computer-related text: <code> for code, <kbd> for keys, <samp> for program output and <var> for variables. They are usually shown in a monospace font.\n\n" +
            "<pre> keeps spaces and line breaks exactly as you typed them, so you can show multi-line code.",
        codeExample = """
            <p>Use <code>print()</code> to show text.</p>
            <p>Press <kbd>Ctrl</kbd> + <kbd>S</kbd> to save.</p>
            <p>Output: <samp>Hello</samp></p>
            <p>Formula: <var>x</var> = 5</p>
            <pre>
            Line 1
                Line 2 keeps its spaces
            </pre>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag keeps spaces and line breaks?",
            options = listOf("<code>", "<pre>", "<samp>", "<var>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_semantic",
        title = "32. Semantic elements",
        category = "HTML",
        description = "Instead of using <div> everywhere, there are tags that show the role of each area: <header>, <nav> (navigation menu), <main> (main content), <section> and <footer>.\n\n" +
            "They don't change the look, but they help search engines, screen readers and you to read the code.",
        codeExample = """
            <header><h1>My Blog</h1></header>
            <nav><a href="#">Home</a> | <a href="#">Contact</a></nav>
            <main>
              <section><p>The main content.</p></section>
            </main>
            <footer><p>Footer</p></footer>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag defines the footer of a page?",
            options = listOf("<footer>", "<header>", "<main>", "<nav>"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_styleguide",
        title = "33. Style Guide",
        category = "HTML",
        description = "Clean code is easy to read and maintain. Always declare <!DOCTYPE html> and the language with <html lang=\"en\">. Write tags and attributes in lowercase, close all elements and put attribute values in quotes.\n\n" +
            "Always add alt to images, use indentation to show the structure and give files lowercase names without spaces, e.g. my-page.html.",
        codeExample = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
              <meta charset="UTF-8">
              <title>Style guide</title>
            </head>
            <body>
              <h1>Clean code</h1>
              <img src="cat.jpg" alt="A cat">
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute of <html> declares the language of the page?",
            options = listOf("language", "locale", "lang", "type"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_entities",
        title = "34. Entities and Symbols",
        category = "HTML",
        description = "Entities are codes that start with & and end with ;. You use them for characters that belong to the syntax (&lt; &gt; &amp;), for the non-breaking space &nbsp; and for symbols such as &copy; &euro; &hearts;.\n\n" +
            "You can also write a character by its number, e.g. &#9731; or &#x2605;. This lets you add symbols that are not on the keyboard.",
        codeExample = """
            <p>5 &lt; 10 and 10 &gt; 5</p>
            <p>&copy; 2026 &mdash; All rights reserved</p>
            <p>Price: 20&euro; &nbsp;&nbsp; Love: &hearts;</p>
            <p>By number: &#9731; &#x2605;</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which entity shows the < symbol?",
            options = listOf("&gt;", "&amp;", "&nbsp;", "&lt;"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_emojis",
        title = "35. Emojis",
        category = "HTML",
        description = "Emojis are simple Unicode characters, so you place them in the page like normal text. To display them correctly the page must use the UTF-8 encoding: <meta charset=\"UTF-8\">.\n\n" +
            "You can write them directly or by their number, e.g. &#128512;. Increasing the font-size makes them bigger.",
        codeExample = """
            <meta charset="UTF-8">
            <p style="font-size: 32px;">😀 😍 🚀</p>
            <p style="font-size: 32px;">&#128512; &#128640; &#127775;</p>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which encoding do you need for emojis to work properly?",
            options = listOf("UTF-8", "ASCII", "Binary", "Base-10"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_charsets",
        title = "36. Character Sets",
        category = "HTML",
        description = "The browser needs to know which code to use to read the characters in the file. You set it with <meta charset=\"UTF-8\"> inside the <head>.\n\n" +
            "UTF-8 is the modern standard and covers almost all characters in the world: Greek, Latin, Chinese, emoji. Older sets such as ASCII and ISO-8859-1 have far fewer characters.",
        codeExample = """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="UTF-8">
              <title>Charset</title>
            </head>
            <body>
              <p>Ελληνικά, café, 日本語, 😀</p>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which character set is recommended today?",
            options = listOf("ASCII", "UTF-8", "ISO-8859-1", "Windows-1252"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_urlencode",
        title = "37. URL Encode",
        category = "HTML",
        description = "URLs may only contain certain characters. The others are replaced by the % sign and a code. For example, a space becomes %20 and & becomes %26.\n\n" +
            "JavaScript has the encodeURIComponent function, which does the conversion. You use it when you place user text inside an address.",
        codeExample = """
            <p id="out"></p>
            <script>
              var text = "Hello world & café";
              document.getElementById("out").textContent = encodeURIComponent(text);
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "What does a space become in a URL?",
            options = listOf("%00", "&nbsp;", "%20", "%space"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_xhtml",
        title = "38. HTML vs. XHTML",
        category = "HTML",
        description = "XHTML is a stricter version of HTML, based on XML. It requires lowercase tags and attributes, every element closed, attribute values in quotes and correct nesting.\n\n" +
            "Empty elements are closed with a slash at the end, e.g. <br />. Modern HTML is more relaxed, but writing clean code like XHTML is a good habit.",
        codeExample = """
            <p>XHTML style:</p>
            <br />
            <img src="cat.jpg" alt="A cat" />
            <input type="text" value="Hello" />
        """.trimIndent(),
        quiz = Quiz(
            question = "What does XHTML require compared to HTML?",
            options = listOf("There must be no images", "Everything is written in capitals", "There must be no CSS", "Every element must be closed"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_forms",
        title = "39. Forms (form, input)",
        category = "HTML",
        description = "Forms collect data from the user. <form> contains the fields. <input> makes a field and its kind is set by the type attribute: text, password, email, checkbox and more.\n\n" +
            "<label> gives the field a name and <button> makes a button. In the preview the form isn't sent anywhere, it is only displayed.",
        codeExample = """
            <form>
              <label>Name: <input type="text"></label>
              <br>
              <label>Email: <input type="email"></label>
              <br>
              <label><input type="checkbox"> I want updates</label>
              <br>
              <button>Send</button>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute sets the kind of an input field?",
            options = listOf("type", "kind", "form", "label"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_formattrs",
        title = "40. Form Attributes",
        category = "HTML",
        description = "The action attribute sets where the form data is sent and method sets how: get (inside the address) or post (hidden in the request body). target sets where the response opens.\n\n" +
            "With autocomplete=\"off\" the browser does not suggest old values and with novalidate the form is sent without checking. Fields need a name to be sent.",
        codeExample = """
            <form action="/submit" method="post" autocomplete="off">
              <label>Name: <input type="text" name="username"></label>
              <br>
              <button type="submit">Send</button>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute sets where the form data is sent?",
            options = listOf("action", "target-url", "send", "method"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_formelements",
        title = "41. Form Elements",
        category = "HTML",
        description = "Besides <input>, forms have other elements: <select> with <option> makes a drop-down list, <textarea> a multi-line field and <fieldset> with <legend> groups fields.\n\n" +
            "<label> with the for attribute links to a field through its id, so clicking the text selects the field.",
        codeExample = """
            <form>
              <label for="c">Country:</label>
              <select id="c">
                <option>Greece</option>
                <option>Cyprus</option>
              </select>
              <br>
              <textarea rows="2" cols="20">Your message</textarea>
              <fieldset>
                <legend>Choose</legend>
                <label><input type="radio" name="r"> A</label>
                <label><input type="radio" name="r"> B</label>
              </fieldset>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which element creates a drop-down list?",
            options = listOf("<list>", "<select>", "<dropdown>", "<textarea>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_inputtypes",
        title = "42. Input Types",
        category = "HTML",
        description = "The type attribute completely changes how an <input> behaves. Some types: text, password (hides the characters), email, number, date, color (colour picker), range (slider), checkbox, radio and file.\n\n" +
            "Modern browsers show a suitable keyboard or picker for each type and check the values automatically.",
        codeExample = """
            <form>
              <input type="password" placeholder="Password"><br>
              <input type="number" value="5"><br>
              <input type="date"><br>
              <input type="color" value="#ff5722"><br>
              <input type="range" min="0" max="10"><br>
              <label><input type="checkbox"> I agree</label>
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which type hides the characters you type?",
            options = listOf("secret", "hidden-text", "password", "text"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_inputattrs",
        title = "43. Input Attributes",
        category = "HTML",
        description = "The attributes of <input> configure the field: value (initial value), placeholder (hint inside the empty field), required, readonly, disabled, maxlength (maximum characters), min and max (number limits) and autofocus.\n\n" +
            "pattern accepts a regular expression to check the value, e.g. pattern=\"[0-9]{4}\" for four digits.",
        codeExample = """
            <form>
              <input type="text" placeholder="Your name" required><br>
              <input type="text" value="Read only" readonly><br>
              <input type="text" maxlength="5" placeholder="Max 5 chars"><br>
              <input type="number" min="1" max="10" value="3">
            </form>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute shows a hint inside an empty field?",
            options = listOf("value-hint", "tooltip", "label", "placeholder"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_inputformattrs",
        title = "44. Input Form Attributes",
        category = "HTML",
        description = "A button or field can change the behaviour of the form with its own attributes: formaction (another address to send to), formmethod (another method), formtarget and formnovalidate.\n\n" +
            "The form attribute links a field to a form through its id, even if the field is outside the <form>.",
        codeExample = """
            <form id="myform" action="/save" method="post">
              <input type="text" name="n">
              <button type="submit">Save</button>
              <button type="submit" formaction="/preview" formmethod="get">Preview</button>
            </form>
            <input type="text" form="myform" placeholder="Outside, but in the form">
        """.trimIndent(),
        quiz = Quiz(
            question = "What does the formaction attribute do on a button?",
            options = listOf("It changes the address to send to for that button only", "It changes the colour of the button", "It deletes the form", "It hides the button"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_canvas",
        title = "45. Canvas",
        category = "HTML",
        description = "<canvas> is a drawing surface. By itself it is empty: you draw shapes with JavaScript. You get the \"brush\" with getContext(\"2d\") and then use commands such as fillRect (rectangle) and arc (circle).\n\n" +
            "fillStyle sets the colour. Coordinates start from the top-left corner (0, 0).",
        codeExample = """
            <canvas id="c" width="200" height="100" style="border: 1px solid #888;"></canvas>
            <script>
              var ctx = document.getElementById("c").getContext("2d");
              ctx.fillStyle = "tomato";
              ctx.fillRect(20, 20, 80, 50);
              ctx.beginPath();
              ctx.arc(150, 50, 30, 0, 2 * Math.PI);
              ctx.fillStyle = "royalblue";
              ctx.fill();
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag defines the drawing surface?",
            options = listOf("<paint>", "<canvas>", "<draw>", "<svg-area>"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_svg",
        title = "46. SVG",
        category = "HTML",
        description = "SVG (Scalable Vector Graphics) draws vector graphics with code. You place <svg> directly in the page and put shapes inside it such as <rect> (rectangle), <circle>, <line> and <text>.\n\n" +
            "Vector graphics do not lose quality however much they are enlarged. This makes them ideal for icons and logos.",
        codeExample = """
            <svg width="200" height="100">
              <rect x="10" y="10" width="80" height="60" fill="tomato" />
              <circle cx="150" cy="50" r="30" fill="royalblue" />
              <text x="10" y="90" fill="black">SVG</text>
            </svg>
        """.trimIndent(),
        quiz = Quiz(
            question = "What is special about SVG graphics?",
            options = listOf("They only work on phones", "They cannot have colour", "They do not lose quality when enlarged", "They always need an image file"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_media",
        title = "47. Media",
        category = "HTML",
        description = "HTML can play video and audio without plugins, using the <video> and <audio> tags. Browsers support specific formats: MP4, WebM and Ogg for video, MP3, WAV and Ogg for audio.\n\n" +
            "With several <source> tags inside the same element you offer alternative formats and the browser picks the first one it supports. There are no media files in the preview, so you only see the controls.",
        codeExample = """
            <video width="260" controls>
              <source src="movie.mp4" type="video/mp4">
              Your browser does not support video.
            </video>
            <br>
            <audio controls>
              <source src="sound.mp3" type="audio/mpeg">
              Your browser does not support audio.
            </audio>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which audio format do browsers support?",
            options = listOf("DOCX", "PSD", "EXE", "MP3"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_video",
        title = "48. Video",
        category = "HTML",
        description = "<video> displays a video. The controls attribute adds play buttons, volume and full screen. With width and height you set the size.\n\n" +
            "autoplay starts it by itself (usually together with muted) and loop repeats it. The text inside the tag is only shown if the browser does not support video.",
        codeExample = """
            <video width="280" controls>
              <source src="movie.mp4" type="video/mp4">
              <source src="movie.webm" type="video/webm">
              Your browser does not support video.
            </video>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute shows the play buttons?",
            options = listOf("controls", "buttons", "play", "show"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_audio",
        title = "49. Audio",
        category = "HTML",
        description = "<audio> plays sound, e.g. music or a recording. controls shows the play buttons. <source> sets the file and its type (audio/mpeg for MP3).\n\n" +
            "With loop the sound repeats forever and with muted it starts silent. Most browsers do not allow autoplay of sound without user interaction.",
        codeExample = """
            <audio controls loop>
              <source src="sound.mp3" type="audio/mpeg">
              <source src="sound.ogg" type="audio/ogg">
              Your browser does not support audio.
            </audio>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute makes the audio repeat?",
            options = listOf("repeat", "loop", "again", "cycle"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_youtube",
        title = "50. YouTube Videos",
        category = "HTML",
        description = "To place a YouTube video in your page, use an <iframe>. In src you write the address https://www.youtube.com/embed/ followed by the video id (the part after v= in its address).\n\n" +
            "The allowfullscreen attribute allows full screen. The preview has no internet access, so the video will not load here.",
        codeExample = """
            <iframe width="280" height="160"
              src="https://www.youtube.com/embed/VIDEO_ID"
              title="YouTube video" allowfullscreen></iframe>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag do you use to embed a YouTube video?",
            options = listOf("<youtube>", "<video-link>", "<iframe>", "<embed-yt>"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_webapis",
        title = "51. Web APIs",
        category = "HTML",
        description = "Web APIs are ready-made browser features you use with JavaScript: location, data storage, dragging elements, background tasks and more. You do not need to install them.\n\n" +
            "Before using an API it is a good idea to check whether the browser supports it. The example shows which of them are available here.",
        codeExample = """
            <p id="out"></p>
            <script>
              var apis = [];
              if ("geolocation" in navigator) apis.push("Geolocation");
              if ("localStorage" in window) apis.push("Web Storage");
              if (window.Worker) apis.push("Web Workers");
              if (window.EventSource) apis.push("Server-Sent Events");
              document.getElementById("out").textContent = "Available: " + apis.join(", ");
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "What is a Web API?",
            options = listOf("A type of image", "A database server", "A text editing program", "A ready-made browser feature you call with JavaScript"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_geolocation",
        title = "52. Geolocation API",
        category = "HTML",
        description = "The Geolocation API finds the user's position. You call navigator.geolocation.getCurrentPosition, which takes two functions: one for success (with the pos object, containing coords.latitude and coords.longitude) and one for errors.\n\n" +
            "The browser always asks for the user's permission. In the app's preview the permission is most likely not granted and you will see the error message, which is also a valid result.",
        codeExample = """
            <button onclick="getLocation()">Where am I?</button>
            <p id="out"></p>
            <script>
              function getLocation() {
                var out = document.getElementById("out");
                if (!navigator.geolocation) { out.textContent = "Not supported."; return; }
                navigator.geolocation.getCurrentPosition(
                  function (pos) { out.textContent = pos.coords.latitude + ", " + pos.coords.longitude; },
                  function (err) { out.textContent = "Error: " + err.message; }
                );
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which method gets the current position?",
            options = listOf("getCurrentPosition", "findMe", "locate", "getPlace"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_dragdrop",
        title = "53. Drag and Drop API",
        category = "HTML",
        description = "To make an element draggable you add draggable=\"true\". The area that accepts it listens for the dragover and drop events. In dragover you must call preventDefault(), otherwise dropping is not allowed.\n\n" +
            "In drop you move the element with appendChild. Note: on touch screens dragging with this API may not work in every browser.",
        codeExample = """
            <style>
              #box { width: 80px; height: 60px; background: orange; }
              #zone { width: 180px; height: 100px; margin-top: 8px; border: 2px dashed #888; }
            </style>
            <div id="box" draggable="true">Drag me</div>
            <div id="zone">Drop here</div>
            <script>
              var box = document.getElementById("box");
              var zone = document.getElementById("zone");
              zone.addEventListener("dragover", function (e) { e.preventDefault(); });
              zone.addEventListener("drop", function (e) {
                e.preventDefault();
                zone.appendChild(box);
              });
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute makes an element draggable?",
            options = listOf("movable=\"yes\"", "draggable=\"true\"", "drag=\"on\"", "dropzone=\"true\""),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_popover",
        title = "54. Popover API",
        category = "HTML",
        description = "The Popover API creates pop-up windows without JavaScript. You add the popover attribute to the element and popovertarget with its id to a button. Pressing the button opens and closes the pop-up.\n\n" +
            "It also closes when you click outside it or press the Esc key. If your device's WebView version is old, it may not work.",
        codeExample = """
            <button popovertarget="info">Show info</button>
            <div id="info" popover style="padding: 16px;">
              Hello! I am a popover.<br>Click outside to close me.
            </div>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which attribute turns an element into a popover?",
            options = listOf("popup", "overlay", "popover", "float"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_webstorage",
        title = "55. Web Storage API",
        category = "HTML",
        description = "Web Storage saves data inside the browser, without a server. localStorage keeps the data even after the tab is closed, while sessionStorage keeps it only while the tab is open. You use setItem to write and getItem to read.\n\n" +
            "Values are always stored as text. In the preview storage may be disabled, so the code uses try/catch and shows a message.",
        codeExample = """
            <p id="out"></p>
            <script>
              var out = document.getElementById("out");
              try {
                var visits = Number(localStorage.getItem("visits")) || 0;
                visits = visits + 1;
                localStorage.setItem("visits", visits);
                out.textContent = "Visits: " + visits;
              } catch (e) {
                out.textContent = "Storage is not available here: " + e.name;
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which one keeps data after the tab is closed?",
            options = listOf("sessionStorage", "Both equally", "Neither", "localStorage"),
            correctOptionIndex = 3,
        ),
    ),
    Lesson(
        id = "html_webworkers",
        title = "56. Web Workers API",
        category = "HTML",
        description = "A web worker runs JavaScript code in the background, in a separate thread, so the page does not \"freeze\" during heavy calculations. You create it with new Worker and talk to it with postMessage and onmessage.\n\n" +
            "Here the worker is built from text using a Blob, so no separate file is needed. If the environment does not allow it, you will see a message.",
        codeExample = """
            <p id="out">Calculating...</p>
            <script>
              var out = document.getElementById("out");
              try {
                var code = "onmessage = function (e) { var s = 0; for (var i = 0; i <= e.data; i++) s += i; postMessage(s); };";
                var worker = new Worker(URL.createObjectURL(new Blob([code])));
                worker.onmessage = function (e) { out.textContent = "Sum = " + e.data; worker.terminate(); };
                worker.postMessage(1000000);
              } catch (err) {
                out.textContent = "Workers are not available here: " + err.name;
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "Where does the code of a web worker run?",
            options = listOf("In the background, in a separate thread", "Inside the <head>", "On the server", "Inside an iframe"),
            correctOptionIndex = 0,
        ),
    ),
    Lesson(
        id = "html_sse",
        title = "57. Server-Sent Events API",
        category = "HTML",
        description = "Server-Sent Events (SSE) let a server keep sending new data to the page, e.g. news or stock prices. You open the connection with new EventSource(address) and read the messages in onmessage.\n\n" +
            "The direction is only from the server to the browser. Since there is no server here, the example shows an error message, but the code is correct.",
        codeExample = """
            <p id="out">Waiting for server events...</p>
            <script>
              var out = document.getElementById("out");
              try {
                var source = new EventSource("https://example.com/events");
                source.onmessage = function (e) { out.textContent = e.data; };
                source.onerror = function () {
                  out.textContent = "No server here, but the code is correct!";
                  source.close();
                };
              } catch (err) {
                out.textContent = "EventSource is not available: " + err.name;
              }
            </script>
        """.trimIndent(),
        quiz = Quiz(
            question = "In which direction is data sent in SSE?",
            options = listOf("From the browser to the server", "From the server to the browser", "Both directions", "Between two browsers"),
            correctOptionIndex = 1,
        ),
    ),
    Lesson(
        id = "html_accessibility",
        title = "58. Accessibility",
        category = "HTML",
        description = "Accessibility means a page can be used by everyone, including people who have trouble seeing or hearing or who do not use a mouse. Add alt to images, label to fields, semantic tags and enough colour contrast.\n\n" +
            "When a button has only an icon, add aria-label so a screen reader can read it. Make sure everything also works with the keyboard.",
        codeExample = """
            <button aria-label="Close menu" style="font-size: 20px;">✕</button>
            <br><br>
            <label for="email">Email:</label>
            <input id="email" type="email">
            <br><br>
            <img src="chart.png" alt="Sales grew 20% in 2026">
        """.trimIndent(),
        quiz = Quiz(
            question = "What helps a screen reader describe an image?",
            options = listOf("The width attribute", "The background colour", "The alt attribute", "Only the file name"),
            correctOptionIndex = 2,
        ),
    ),
    Lesson(
        id = "html_project",
        title = "59. Project",
        category = "HTML",
        description = "Time to combine what you have learned into a complete page: structure with header, main and footer, headings, text, a list, a link, an image and a little CSS.\n\n" +
            "Copy the code, change the texts and colours and build your own personal page. Save it as index.html and open it in your browser.",
        codeExample = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
              <meta charset="UTF-8">
              <title>About me</title>
              <style>
                body { font-family: sans-serif; margin: 0; }
                header, footer { background: #3f51b5; color: white; padding: 12px; text-align: center; }
                main { padding: 12px; }
              </style>
            </head>
            <body>
              <header><h1>Hi, I am Alex</h1></header>
              <main>
                <h2>My hobbies</h2>
                <ul>
                  <li>Coding</li>
                  <li>Music</li>
                </ul>
                <img src="me.jpg" alt="A photo of me" width="120">
                <p>Read more on <a href="https://example.com">my blog</a>.</p>
              </main>
              <footer>&copy; 2026 Alex</footer>
            </body>
            </html>
        """.trimIndent(),
        quiz = Quiz(
            question = "Which tag do you use for the main content of the page?",
            options = listOf("<head>", "<title>", "<meta>", "<main>"),
            correctOptionIndex = 3,
        ),
    ),
)
