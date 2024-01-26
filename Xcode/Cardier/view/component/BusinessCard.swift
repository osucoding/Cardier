//
//  BusinessCard.swift
//  Cardier
//
//  Created by John Choi on 1/17/24.
//

import SwiftUI

struct BusinessCard: View {

    private let screenWidth = UIScreen.main.bounds.width

    let cardPayload: BusinessCardPayload

    private let rotationValue: Double = 270

    var body: some View {
        VStack {
            VStack {
                HStack {
                    // Render optional image
                    Image(systemName: "photo")
                        .rotationEffect(.degrees(rotationValue))
                    Spacer()
                    EmptyView()
                }

                Spacer()

                HStack {
                    EmptyView()

                    Spacer()

                    VStack(alignment: .leading) {
                        Text(cardPayload.displayName)
                        Text(cardPayload.phone)
                        Text(cardPayload.email)
                        Text(cardPayload.companyName)
                    }
                    .rotationEffect(.degrees(rotationValue))
                    .frame(minHeight: 200)
                }
            }

            .padding()
            .frame(width: 300, height: 400)
            .background(Color(uiColor: .systemBackground))
            .cornerRadius(15)
            .shadow(color: Color.gray.opacity(0.5), radius: 7, x: 0, y: 5)
        }
    }
}

#Preview {
    BusinessCard(cardPayload: BusinessCardPayload(displayName: "John Doe", email: "john.doe@email.com", phone: "999-999-9999", companyName: "My Company"))
}
