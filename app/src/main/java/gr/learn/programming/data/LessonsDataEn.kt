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
)
