//
//  HomeView.swift
//  Cardier
//
//  Created by John Choi on 1/26/24.
//

import SwiftUI

struct HomeView: View {

    // TODO: replace this with actual data later
    private var sampleBusinessCards = [
        BusinessCardPayload(displayName: "Name 0", email: "email0@email.com", phone: "111-111-1111", companyName: "Company 0"),
        BusinessCardPayload(displayName: "Name 1", email: "email1@email.com", phone: "222-222-2222", companyName: "Company 1"),
        BusinessCardPayload(displayName: "Name 2", email: "email2@email.com", phone: "333-333-3333", companyName: "Company 2"),
        BusinessCardPayload(displayName: "Name 3", email: "email3@email.com", phone: "444-444-4444", companyName: "Company 3"),
        BusinessCardPayload(displayName: "Name 4", email: "email4@email.com", phone: "555-555-5555", companyName: "Company 4"),
    ]

    var body: some View {
        NavigationView {
            ScrollView {
                VStack {
                    ScrollView(.horizontal) {
                        HStack(spacing: 15) {
                            ForEach(sampleBusinessCards) { card in
                                BusinessCard(cardPayload: card)
                            }
                        }
                        .padding()
                    }
                    .scrollIndicators(.hidden)
                    .padding()
                }
                .navigationTitle("My Business Cards")
                .navigationBarTitleDisplayMode(.large)
            }
            .scrollIndicators(.hidden)
            .toolbar {
                Button("Notifications", systemImage: "bell", action: {
                    // TODO: implement button action
                })
                Button("About", systemImage: "ellipsis", action: {
                    // TODO: implement button action
                })
            }
            // set the background color
            .background(Color(uiColor: .systemGray5))
        }
    }
}

#Preview {
    HomeView()
}
