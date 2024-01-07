//
//  CardierApp.swift
//  Cardier
//
//  Created by John Choi on 1/7/24.
//

import SwiftUI

@main
struct CardierApp: App {
    let persistenceController = PersistenceController.shared

    var body: some Scene {
        WindowGroup {
            ContentView()
                .environment(\.managedObjectContext, persistenceController.container.viewContext)
        }
    }
}
