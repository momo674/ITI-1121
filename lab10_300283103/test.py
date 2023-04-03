import tkinter as tk
import webbrowser

def open_website():
    webbrowser.open("https://www.google.com")

root = tk.Tk()

# Create a button that opens the website when clicked
button = tk.Button(root, text="Open Google", command=open_website)
button.pack()

root.mainloop()
