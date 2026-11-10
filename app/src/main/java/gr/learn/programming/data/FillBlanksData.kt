package gr.learn.programming.data

import gr.learn.programming.model.FillBlank

private fun b(vararg accepted: String): List<String> = accepted.toList()

private fun fb(code: String, vararg answers: List<String>) =
    FillBlank(code = code.trimIndent(), answers = answers.toList())

/** Κάθε τιμή που η Python θεωρεί «ψεύτικη» (False) — δεκτή όπου ζητάμε κάτι που βγάζει False. */
private val falsy = b("\"\"", "''", "0", "0.0", "[]", "{}", "()", "None", "False")

/**
 * Ασκήσεις συμπλήρωσης κενών, με το id του μαθήματος ως κλειδί.
 * Ο κώδικας είναι ίδιος για όλες τις γλώσσες της εφαρμογής (δεν έχει κείμενο που χρειάζεται μετάφραση).
 */
val fillBlanks: Map<String, FillBlank> = mapOf(
    "python_intro" to fb(
        """
        ___("Hello, world!")
        print("Python ___ easy")
        """,
        b("print"), b("is"),
    ),
    "python_syntax" to fb(
        """
        if 5 ___ 2:
            ___("5 is greater than 2")
            print("This line belongs to the same block")

        print("This one is outside the block")
        """,
        b(">"), b("print"),
    ),
    "python_output" to fb(
        """
        print("Hello", "there", 2026)
        print("A", "B", "C", ___="-")
        print("No new line", ___=" ")
        print("continues here")
        """,
        b("sep"), b("end"),
    ),
    "python_comments" to fb(
        """
        ___ This is a comment
        print("Hi")  ___ comment at the end of the line

        ___ print("This line will not run")
        print("The end")
        """,
        b("#"), b("#"), b("#"),
    ),
    "python_variables" to fb(
        """
        name = "Maria"
        age = 25
        height = ___
        is_student = ___

        print(name)
        age = age ___ 1
        print("Next year I will be", age)
        """,
        b("1.68"), b("True"), b("+"),
    ),
    "python_datatypes" to fb(
        """
        print(___("hello"))
        print(___(10))
        print(type(3.14))
        print(type(___))   # <class 'bool'>
        print(type([1, 2, 3]))
        """,
        b("type"), b("type"), b("True", "False"),
    ),
    "python_numbers" to fb(
        """
        a = 7
        b = 2.5
        big = 10 ___ 20

        print(a + b)
        print(7 / 2)     # 3.5
        print(7 ___ 2)   # 3
        print(7 ___ 2)   # 1
        """,
        b("**"), b("//"), b("%"),
    ),
    "python_casting" to fb(
        """
        x = ___("5") + 3
        y = float(2) + 0.5
        z = ___(100) + " euros"

        print(x)
        print(y)
        print(z)
        print(___(9.99))   # 9
        """,
        b("int"), b("str"), b("int"),
    ),
    "python_strings" to fb(
        """
        s = "Hello Python"

        print(___(s))
        print(s[___])
        print(s[0:___])
        print(s.___())
        print(s.replace("Python", "world"))
        print("Python" ___ s)
        """,
        b("len"), b("0"), b("5"), b("upper"), b("in"),
    ),
    "python_booleans" to fb(
        """
        print(10 ___ 5)    # True
        print(10 ___ 5)    # False
        print(bool("hello"))
        print(bool(___))   # False
        print(bool(___))   # False
        print(bool([1]))
        """,
        b(">"), b("=="), falsy, falsy,
    ),
    "python_operators" to fb(
        """
        x = 10
        x ___ 5
        print(x)          # 15
        print(2 ___ 3)    # 8
        print(x > 10 ___ x < 20)
        print(___ True)   # False
        print(3 ___ [1, 2, 3])
        """,
        b("+="), b("**"), b("and"), b("not"), b("in"),
    ),
    "python_lists" to fb(
        """
        fruits = ["apple", "banana", "orange"]

        print(fruits[___])       # apple
        fruits.___("cherry")     # add at the end
        print(___(fruits))       # 4

        fruits[1] = "kiwi"
        print(fruits)
        """,
        b("0"), b("append"), b("len"),
    ),
    "python_tuples" to fb(
        """
        point = (10, ___)
        print(point[___])
        print(___(point))

        x, y = ___
        print(x, y)
        """,
        b("20"), b("0"), b("len"), b("point"),
    ),
    "python_sets" to fb(
        """
        numbers = {1, 2, 2, 3, 3, 3}
        print(numbers)

        numbers.___(4)
        print(len(numbers))

        a = {1, 2, 3}
        b = {3, 4, 5}
        print(a ___ b)   # {1, 2, 3, 4, 5}
        print(a ___ b)   # {3}
        """,
        b("add"), b("|"), b("&"),
    ),
    "python_dictionaries" to fb(
        """
        person = {"name": "Maria", "age": 25}

        print(person[___])
        person["city"] = "Athens"

        for key, value in person.___():
            print(key, "->", value)

        print(person.___("color", "unknown"))
        """,
        b("\"name\"", "'name'"), b("items"), b("get"),
    ),
    "python_conditions" to fb(
        """
        temperature = 30

        ___ temperature > 35:
            print("It's a heatwave!")
        ___ temperature > 20:
            print("Warm, nice day.")
        ___:
            print("Put something warm on.")
        """,
        b("if"), b("elif"), b("else"),
    ),
    "python_match" to fb(
        """
        day = 6

        ___ day:
            ___ 1 | 2 | 3 | 4 | 5:
                print("Weekday")
            case 6 | 7:
                print("Weekend")
            case ___:
                print("Unknown day")
        """,
        b("match"), b("case"), b("_"),
    ),
    "python_loops" to fb(
        """
        ___ i in range(1, 4):
            print("Round", i)

        count = 3
        ___ count > 0:
            print(count)
            count = count ___ 1

        print("Here we go!")
        """,
        b("for"), b("while"), b("-"),
    ),
    "python_range" to fb(
        """
        print(list(range(___)))          # [0, 1, 2, 3, 4]
        print(list(range(2, ___)))       # [2, 3, 4, 5]
        print(list(range(0, 10, ___)))   # [0, 3, 6, 9]
        print(list(range(5, 0, ___)))    # [5, 4, 3, 2, 1]
        """,
        b("5"), b("6"), b("3"), b("-1"),
    ),
    "python_functions" to fb(
        """
        ___ greet(name, greeting="Hello"):
            ___ greeting + ", " + name + "!"

        def add(a, b):
            return a + b

        print(greet("Maria"))
        print(add(3, ___))   # 7
        """,
        b("def"), b("return"), b("4"),
    ),
    "python_arrays" to fb(
        """
        grid = [
            [1, 2, 3],
            [4, 5, 6],
        ]

        print(grid[1][___])   # 6
        print(___(grid))      # 2

        ___ row in grid:
            print(row)

        print([x * 2 ___ x in grid[0]])
        """,
        b("2"), b("len"), b("for"), b("for"),
    ),
    "python_iterators" to fb(
        """
        fruits = ["apple", "banana", "cherry"]
        it = ___(fruits)

        print(___(it))
        print(next(it))
        print(next(it))

        for letter in "Py":
            print(letter)
        """,
        b("iter"), b("next"),
    ),
    "python_modules" to fb(
        """
        ___ random
        import math ___ m
        ___ statistics import mean

        print(random.randint(1, 6))
        print(m.sqrt(49))
        print(mean([2, 4, 6]))
        """,
        b("import"), b("as"), b("from"),
    ),
    "python_dates" to fb(
        """
        from datetime import datetime, date, timedelta

        d = date(2026, 11, ___)
        print(d)                       # 2026-11-09
        print(d.___("%d/%m/%Y"))
        print(d + ___(days=30))
        """,
        b("9"), b("strftime"), b("timedelta"),
    ),
    "python_math" to fb(
        """
        import math

        print(___(3, 7, 1), max(3, 7, 1))
        print(___(-5))
        print(___(3.14159, 2))
        print(math.___(16))
        print(math.ceil(2.1), math.___(2.9))
        print(math.pi)
        """,
        b("min"), b("abs"), b("round"), b("sqrt"), b("floor"),
    ),
    "python_json" to fb(
        """
        import json

        text = '{"name": "Maria", "age": 25}'
        data = json.___(text)
        print(data["name"])

        data["age"] = 26
        print(json.___(data, ensure_ascii=False))
        """,
        b("loads"), b("dumps"),
    ),
    "python_regex" to fb(
        """
        import re

        text = "Phone numbers: 6912345678 and 2101234567"

        print(re.___(r"\d+", text))
        print(re.___(r"\d{10}", text).group())
        print(re.___(r"\d", "*", "Code 1234"))
        """,
        b("findall"), b("search"), b("sub"),
    ),
    "python_pip" to fb(
        """
        #   pip ___ requests
        #   pip list

        import importlib.util

        for name in ["json", "random", "something_that_does_not_exist"]:
            found = importlib.util.find_spec(name) is ___ None
            print(name, "->", "exists" ___ found else "does not exist")
        """,
        b("install"), b("not"), b("if"),
    ),
    "python_try_except" to fb(
        """
        ___:
            number = int("abc")
        ___ ValueError:
            print("That's not a number!")
        ___:
            print("All good:", number)
        ___:
            print("This always runs")
        """,
        b("try"), b("except"), b("else"), b("finally"),
    ),
    "python_string_formatting" to fb(
        """
        name = "Maria"
        price = 4.5
        qty = 3

        print(___"Hello {name}!")
        print(f"Total: {price * qty:___} euros")
        print(f"{1234567:___}")
        """,
        b("f"), b(".2f"), b(","),
    ),
    "python_none" to fb(
        """
        result = ___
        print(result)
        print(result ___ None)

        def say_hi():
            print("Hi!")

        value = say_hi()
        print(value)
        print(type(None))
        """,
        b("None"), b("is"),
    ),
    "python_user_input" to fb(
        """
        #   name = ___("What's your name? ")
        name = "Maria"
        age_text = "25"

        age = ___(age_text)
        print(f"Hello {name}!")
        print("Next year you will be", age ___ 1)
        """,
        b("input"), b("int"), b("+"),
    ),
    "python_virtualenv" to fb(
        """
        #   python -m ___ myenv
        #   source myenv/bin/activate
        #   pip install requests
        #   deactivate

        import sys
        print("Python version:", sys.version.split()[___])
        """,
        b("venv"), b("0"),
    ),
    "python_oop" to fb(
        """
        print(___("text"))
        print(type(5))
        print(type([1, 2]))

        print("python".___())
        print([3, 1, 2].___(1))
        """,
        b("type"), b("upper"), b("count"),
    ),
    "python_classes_objects" to fb(
        """
        ___ Dog:
            species = "dog"

        d1 = Dog()
        d2 = ___()

        print(d1.species)
        print(type(d1))
        print(d1 ___ d2)
        """,
        b("class"), b("Dog"), b("is"),
    ),
    "python_init" to fb(
        """
        class Person:
            def ___(self, name, age):
                self.name = name
                self.age = ___

        p = Person("Maria", 25)
        print(p.name)
        print(p.age)
        """,
        b("__init__"), b("age"),
    ),
    "python_self" to fb(
        """
        class Counter:
            def __init__(___):
                self.value = 0

            def add(self):
                self.value ___ 1

        a = Counter()
        b = Counter()
        a.add()
        a.add()
        b.add()
        print(a.value, b.value)
        """,
        b("self"), b("+="),
    ),
    "python_class_properties" to fb(
        """
        class Car:
            wheels = 4

            def __init__(self, brand):
                self.___ = brand

        c = Car("Toyota")
        print(c.brand, c.wheels)

        c.color = "red"
        print(c.brand, c.color)
        print(___.wheels)
        """,
        b("brand"), b("Car"),
    ),
    "python_class_methods" to fb(
        """
        class BankAccount:
            def __init__(self, balance=0):
                self.balance = balance

            def ___(self, amount):
                self.balance += amount

            def withdraw(self, amount):
                if amount ___ self.balance:
                    print("Not enough money")
                else:
                    self.balance ___ amount

        acc = BankAccount(100)
        acc.deposit(50)
        acc.withdraw(30)
        acc.withdraw(500)
        print(acc.balance)
        """,
        b("deposit"), b(">"), b("-="),
    ),
    "python_magic_methods" to fb(
        """
        class Point:
            def __init__(self, x, y):
                self.x = x
                self.y = y

            def ___(self):
                return f"({self.x}, {self.y})"

            def ___(self, other):
                return Point(self.x + other.x, self.y + other.y)

        a = Point(1, 2)
        b = Point(3, 4)
        print(a)
        print(a + b)
        """,
        b("__str__"), b("__add__"),
    ),
    "python_inheritance" to fb(
        """
        class Animal:
            def __init__(self, name):
                self.name = name

            def eat(self):
                print(self.name, "eats")

        class Dog(___):
            def __init__(self, name, breed):
                ___().__init__(name)
                self.breed = breed

            def bark(self):
                print(self.name, "barks")

        d = Dog("Rex", "Labrador")
        d.___()     # inherited from Animal
        d.bark()
        """,
        b("Animal"), b("super"), b("eat"),
    ),
    "python_polymorphism" to fb(
        """
        class Dog:
            def speak(self):
                return "Woof!"

        class Cat:
            def ___(self):
                return "Meow!"

        class Cow:
            def speak(self):
                return "Moo!"

        ___ animal in [Dog(), Cat(), Cow()]:
            print(animal.___())
        """,
        b("speak"), b("for"), b("speak"),
    ),
    "python_encapsulation" to fb(
        """
        class Wallet:
            def __init__(self):
                self.___money = 0

            def add(self, amount):
                if amount ___ 0:
                    self.__money += amount

            def get_money(self):
                return self.__money

        w = Wallet()
        w.add(50)
        w.add(-20)
        print(w.get_money())

        try:
            print(w.__money)
        ___ AttributeError:
            print("You have no direct access!")
        """,
        b("__"), b(">"), b("except"),
    ),
    "python_inner_classes" to fb(
        """
        class Car:
            def __init__(self, brand):
                self.brand = brand
                self.engine = self.___(120)

            class Engine:
                def __init__(self, horsepower):
                    self.horsepower = horsepower

                def describe(self):
                    return f"Engine with {self.horsepower} horsepower"

        c = Car("Fiat")
        print(c.brand)
        print(c.engine.___())
        """,
        b("Engine"), b("describe"),
    ),
)
