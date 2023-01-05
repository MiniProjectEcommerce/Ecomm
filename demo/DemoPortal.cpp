#include<iostream>
#include<bits/stdc++.h>
#include "Portal.h"
using namespace std;
class DemoPortal:public Portal
{
    private:
	map<int,string> um;//stores the portal id, category
    int portal;
    int reqid=999;
	public:
        DemoPortal(int portalId)
        {
            portal=portalId;
        }
		void processUserCommand(string s)
		{
	        if(s[0]=='S')
			{
				//when input is Start
                freopen("demo/PortalToPlatform.txt","a",stdout);
                reqid++;
                cout<<portal<<' '<<reqid<<' '<<"Start\n";
				//change stdout to terminal
				freopen("/dev/tty","a",stdout);
			}
			else if(s[0]=='L')
			{
				//when input is List
				int n=s.size();
				int c;
				reqid++;
                freopen("demo/PortalToPlatform.txt","a",stdout);
				if(um.find(portal)!=um.end())
				{
					c=0;
				}
				else
				{
					if(s[5]=='B')
					{
						um.insert({portal,"Book"});
					}
					else
					{
						um.insert({portal,"Mobile"});
					}
				}
				if(s[5]=='B')
				{
					cout<<portal<<' '<<reqid<<' '<<"List Book\n";
				}
				else
				{
					cout<<portal<<' '<<reqid<<' '<<"List Mobile\n";
				}
			}
			else if(s[0]=='B')
			{
				//when input is Buy
				string num;
				reqid++;
				freopen("demo/PortalToPlatform.txt","a",stdout);
				int n=s.size();
				int c=0;
				string k;
				string t;
				for(int i=0;i<n;i++)
				{
					if(s[i]==' ' and c<2)
					{
						c++;
						continue;
					}
					else if(c==1)
					{
						t=t+s[i];
					}
					else if(c==2)
					{
						k=k+s[i];
					}
				}
				cout<<portal<<' '<<reqid<<" Buy "<<t<<' '<<k<<'\n';
			}
			else if(s[0]=='C')
			{
				//when input is Check
				checkResponse();
			}
		}
		void checkResponse()
		{
			// check for response
			ifstream in("demo/PlatformToPortal.txt");
			streambuf *cinbuf = std::cin.rdbuf();
			cin.rdbuf(in.rdbuf());
			while(true)
			{
				string s;
				getline(cin,s);
				cout<<s<<'\n';
				int p=s.size();
				if(p==0)
				{
					break;
				}
				else
				{
					for(auto x:um)
					{
						if(x.second=="Start")
						{
							vector<string> vec1;
							string k;
							for(int i=0;i<p;i++)
							{
								if(s[i]==' ')
								{
									vec1.push_back(k);
									k.clear();
								}
								else
								{
									k=k+s[i];
								}
							}
							vec1.push_back(k);
							int y=vec1.size();
							for(int i=2;i<y;i++)
							{
								cout<<vec1[i]<<' ';
							}
							cout<<'\n';
						}
						else if(x.second=="List")
						{
							
						}
					}
				}
			}
			//change stdin to terminal
			cin.rdbuf(cinbuf);
		}
};