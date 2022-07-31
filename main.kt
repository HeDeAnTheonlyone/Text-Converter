fun getText(): String? = readLine()

fun allChars(aChar: Int, upperOrLowerCase: Char) {
    val char: Char?

    when(aChar) {
         0 -> char = '0'
         1 -> char = '1'
         2 -> char = '2'
         3 -> char = '3'
         4 -> char = '4'
         5 -> char = '5'
         6 -> char = '6'
         7 -> char = '7'
         8 -> char = '8'
         9 -> char = '9'
         10 -> char = 'a'
         11 -> char = 'b'
         12 -> char = 'c'
         13 -> char = 'd'
         14 -> char = 'e'
         15 -> char = 'f'
         16 -> char = 'g'
         17 -> char = 'h'
         18 -> char = 'i'
         19 -> char = 'j'
         20 -> char = 'k'
         21 -> char = 'l'
         22 -> char = 'm'
         23 -> char = 'n'
         24 -> char = 'o'
         25 -> char = 'p'
         26 -> char = 'q'
         27 -> char = 'r'
         28 -> char = 's'
         29 -> char = 't'
         30 -> char = 'u'
         31 -> char = 'v'
         32 -> char = 'w'
         33 -> char = 'x'
         34 -> char = 'y'
         35 -> char = 'z'
         36 -> char = 'ß'
         37 -> char = 'ä'
         38 -> char = 'ö'
         39 -> char = 'ü'
         40 -> char = ' '
         41 -> char = '.'
         42 -> char = ','
         43 -> char = '!'
         44 -> char = '?'
         45 -> char = ':'
         46 -> char = '+'
         47 -> char = '-'
         48 -> char = '*'
         49 -> char = '/'
         50 -> char = '_'
         51 -> char = '#'
        else -> char = null
    }
    if(upperOrLowerCase == '^') print(char!!.uppercase()) else print(char)
}

fun specialChars(sChar: Char): Int {
    val charNum: Int

    when(sChar.lowercaseChar()) {
        'ß' -> charNum = 36
        'ä' -> charNum = 37
        'ö' -> charNum = 38
        'ü' -> charNum = 39
        ' ' -> charNum = 40
        '.' -> charNum = 41
        ',' -> charNum = 42
        '!' -> charNum = 43
        '?' -> charNum = 44
        ':' -> charNum = 45
        '+' -> charNum = 46
        '-' -> charNum = 47
        '*' -> charNum = 48
        '/' -> charNum = 49
        '_' -> charNum = 50
        '#' -> charNum = 51
        else -> charNum = 999
    }
    return(charNum)
}

fun encrypt() {
    val text = getText()
    var upOrLowerCase: Char
    var charNum: Int?

    text?.forEach {char ->
        upOrLowerCase = if(char.isLowerCase()) '°' else '^'

        charNum = (char.digitToIntOrNull(radix = 36))
        charNum = charNum ?: specialChars(char)

        print("$upOrLowerCase$charNum,")
    }
}

fun decrypt() {
    var text = getText()
    var char: String
    var charNum: Int
    var upperOrLowerCase: Char

    while(text!!.isNotEmpty()) {
        upperOrLowerCase = text.first()
        text = text.replaceFirstChar {""}

        char = ""
        while(text!!.first() != ',') {
            char += text.first()
            text = text.replaceFirstChar { "" }
        }
        text = text.replaceFirstChar { "" }

        charNum = char.toInt()
        allChars(charNum, upperOrLowerCase)
    }
}

fun main() {
    println("Enter encrypt or decrypt to perform the respective action")
    when(val mode: String? = readLine()) {
        "encrypt" -> encrypt()
        "decrypt" -> decrypt()
        else -> println("$mode is not a valid action. Please use encrypt or decrypt.")
    }
}
