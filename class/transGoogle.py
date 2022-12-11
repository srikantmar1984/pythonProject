from googletrans import Translator
translator=Translator()

inputs= "my name is srikant"
out = translator.translate(inputs,dest='hi')
print(out.text)