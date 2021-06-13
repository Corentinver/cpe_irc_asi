import { TestBed } from '@angular/core/testing';

import { CardShopWebSocketService } from './card-shop-web-socket.service';

describe('CardShopWebSocketService', () => {
  let service: CardShopWebSocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardShopWebSocketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
