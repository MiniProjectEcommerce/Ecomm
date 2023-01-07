#include<iostream>
#include<bits/stdc++.h>
using namespace std;
#include "demo/DemoPortal.h"
int main()
{
	//we take input of the portal ID from the user
	int portalId;
	cout<<"Please enter a Portal_Id: ";
	cin>>portalId;
	DemoPortal dmp(portalId);//to create an object
	while(true)
    {
		//to take input from the user which tells about the commands
        string command;
        getline(cin,command);
		dmp.processUserCommand(command);
	}
	return 0;
}