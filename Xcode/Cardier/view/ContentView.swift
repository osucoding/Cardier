//
//  ContentView.swift
//  Cardier
//
//  Created by John Choi on 1/26/24.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        TabView {
            HomeView()
                .tabItem {
                    Label("Home", systemImage: "house")
                }

            MyPageView()
                .tabItem {
                    Label("My Page", systemImage: "person")
                }
        }
    }
}

#Preview {
    ContentView()
}
