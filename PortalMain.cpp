#include<iostream>
#include<bits/stdc++.h>
using namespace std;
#include "demo/DemoPortal.cpp"
int main()
{
	int portalId;
	cout<<"Please enter a Portal_Id: ";
	cin>>portalId;
	DemoPortal dmp(portalId);
	while(true)
    {
        string command;
        getline(cin,command);
		dmp.processUserCommand(command);
	}
	return 0;
}