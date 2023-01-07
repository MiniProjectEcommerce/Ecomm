#include<bits/stdc++.h>
#include "Portal.h"
using namespace std;
class DemoPortal:public Portal
{
    private:
		map<int,string> ids;//stores the portal id, category
		map<int,string> catName;//stores the portal id, category to be sorted
		map<int,vector<tuple<string,string,int,int>>> Products;//stores the portal id, category to be sorted
		vector<string> others;
		int portal;//stores the portal id
		int reqid=999;//helps to store and assign request id
    public:
        DemoPortal(int); //constructor
        vector<string> split(string str);
        void processUserCommand(string command);
        void checkResponse();
        void ListItems(vector<tuple<string,string,int,int>> items,string basis);
};