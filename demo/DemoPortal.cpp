#include "DemoPortal.h"
#include <bits/stdc++.h>
using namespace std;
DemoPortal::DemoPortal(int portalId) // constructor
{
	portal = portalId;
}
// this is split method, which helps in converting a sentence to a vector of words
vector<string> DemoPortal::split(string str)
{
	vector<string> elems;
	string word = "";
	for (auto x : str)
	{
		if (x == ' ') // whenever a blank is detected it pushes the word in the vector, and clears the word
		{
			elems.push_back(word);
			word = "";
		}
		else // add the characters detected from the string to word
		{
			word = word + x;
		}
	}
	elems.push_back(word); // to push in the last word in the vector
	word.clear();
	return elems;
}
void DemoPortal::processUserCommand(string command) // To process user commands
{
	vector<string> s = split(command);
	if (s[0] == "Start")
	{
		// when input is Start
		freopen("PortalToPlatform.txt", "a", stdout); // to append in file PortalToPlatform
		reqid++;									  // to increment reqid variable which generates the request id
		cout << portal << ' ' << reqid << ' ' << command << "\n";
		ids.insert({reqid, s[0]}); // maintains the order of the commands passed by the user
		// change stdout to terminal
		freopen("/dev/tty", "a", stdout);
	}
	else if (s[0] == "List")
	{
		// when input is List
		reqid++; // to increment reqid variable which generates the request id
		freopen("PortalToPlatform.txt", "a", stdout);
		ids.insert({reqid, s[0]}); // to maintain the order of the commands passed by the user
		catName.insert({reqid, s[2]});
		cout << portal << ' ' << reqid << ' ' << s[0] << ' ' << s[1] << '\n';
		// change stdout to terminal
		freopen("/dev/tty", "a", stdout);
	}
	else if (s[0] == "Buy")
	{
		// when input is Buy
		string num;
		reqid++;
		freopen("PortalToPlatform.txt", "a", stdout);
		ids.insert({reqid, s[0]});
		cout << portal << ' ' << reqid << ' ' << command << '\n';
		// change stdout to terminal
		freopen("/dev/tty", "a", stdout);
	}
	else if (s[0] == "Check")
	{
		// when input is Check
		checkResponse();
	}
}
void DemoPortal::checkResponse()
{
	// check for response
	ifstream in("PlatformToPortal.txt");
	streambuf *cinbuf = cin.rdbuf();
	cin.rdbuf(in.rdbuf());
	int flag = 0;	 // this flag variable triggers the sorting and printing, once it is read
	string commands; // commands is basically the input read from PortalToPlatform.txt
	while (getline(cin, commands))
	{
		int portalId, requestId;
		vector<string> tokens = split(commands); // to split the long string "commands" and form a vector of strings named "tokens"
		portalId = stoi(tokens[0]);				 // typecasting, i.e. to convert integer to string
		requestId = stoi(tokens[1]);			 // typecasting, i.e. to convert integer to string
		if (portalId != portal)					 // if portalId in the sentence read, is not equal to the portal; then push in others vector
		{
			others.push_back(commands);
			continue;
		}
		// if the command is "List" and flag is zero, or if flag doesn't equal to request ID
		if ((ids[requestId] != "List" && flag) || flag != requestId)
		{
			ListItems(Products[flag], catName[flag]);
			flag = 0;
		}
		// if command is "Start"
		if (ids[requestId] == "Start")
		{
			for (int i = 2; i < tokens.size(); i++)
			{
				cout << tokens[i] << ' ';
			}
			cout << '\n';
		}
		// if command is "Buy"
		else if (ids[requestId] == "Buy")
		{
			string response = tokens[2];
			if (response == "Failure")
			{
				cout << "Sorry, your request could not be processed.\n";
			}
			else
			{
				cout << "Items purchased successfully.\n";
			}
		}
		// if command is "List"
		else if (ids[requestId] == "List")
		{
			string name = tokens[2], id = tokens[3];
			int price = stoi(tokens[4]), quantity = stoi(tokens[5]);
			Products[requestId].push_back(make_tuple(name, id, price, quantity));
			flag = requestId;
		}
	}
	if (flag)
	{
		ListItems(Products[flag], catName[flag]);
	}
	cin.rdbuf(cinbuf);
	// to flush the PlatformToPortal.txt on putting Check
	freopen("PlatformToPortal.txt", "w", stdout);
	for (int i = 0; i < others.size(); i++)
	{
		cout << others[i] << '\n';
	}
	// change stdout to terminal
	freopen("/dev/tty", "a", stdout);
}
void DemoPortal ::ListItems(vector<tuple<string, string, int, int>> items, string basis)
{
	// to sort the map
	if (basis == "Name") // if sorting attribute is Name
	{
		sort(items.begin(), items.end(), [](tuple<string, string, int, int> a, tuple<string, string, int, int> b)
			 { return get<0>(a) < get<0>(b); });
	}
	else if (basis == "Price") // if sorting attribute is Price
	{
		sort(items.begin(), items.end(), [](tuple<string, string, int, int> a, tuple<string, string, int, int> b)
			 { return get<2>(a) < get<2>(b); });
	}
	for (auto it : items) // to print the sorted output
	{
		cout << get<0>(it) << " " << get<1>(it) << " " << get<2>(it) << " " << get<3>(it) << '\n';
	}
}
