import urllib.request

def fetch_website(url):
    response = urllib.request.urlopen(url)
    data = response.read()
    content = data.decode('utf-8',errors="ignore")

    while True:
        search = input("Enter the word you want to search for (or type 'exit' to quit): ")
        if search.lower() == "exit":
            break

        count = content.count(search)
        if count > 0:
            print(f"'{search}' is found this many times: {count}")
        else:
            print(f"Didn't find '{search}'")

def main():
    url = input("Enter a URL: ")
    if not url.startswith(('http://', 'https://')):
        url = 'http://' + url
    fetch_website(url)

main()
