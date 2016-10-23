package protocolsupport.protocol.pipeline.version.v_1_7;

import protocolsupport.api.Connection;
import protocolsupport.protocol.packet.middleimpl.serverbound.handshake.v_1_7__1_8__1_9_r1__1_9_r2__1_10.SetProtocol;
import protocolsupport.protocol.packet.middleimpl.serverbound.login.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.EncryptionResponse;
import protocolsupport.protocol.packet.middleimpl.serverbound.login.v_1_7__1_8__1_9_r1__1_9_r2__1_10.LoginStart;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7.Animation;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7.BlockDig;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7.BlockPlace;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7.KeepAlive;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7.Position;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7.TabComplete;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7.UpdateSign;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.Chat;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.CreativeSetSlot;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.Flying;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.HeldSlot;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.InventoryClick;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.InventoryClose;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.InventoryEnchant;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.InventoryTransaction;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_4__1_5__1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.Look;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_6__1_7.EntityAction;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_6__1_7.PositionLook;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_6__1_7.SteerVehicle;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_6__1_7__1_8__1_9_r1__1_9_r2__1_10.PlayerAbilities;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_7.ClientSettings;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_7.CustomPayload;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_7.UseEntity;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_7__1_8__1_9_r1__1_9_r2__1_10.ClientCommand;
import protocolsupport.protocol.packet.middleimpl.serverbound.status.v_1_7__1_8__1_9_r1__1_9_r2__1_10.Ping;
import protocolsupport.protocol.packet.middleimpl.serverbound.status.v_1_7__1_8__1_9_r1__1_9_r2__1_10.ServerInfoRequest;
import protocolsupport.protocol.pipeline.version.AbstractModernWithReorderPacketDecoder;
import protocolsupport.protocol.storage.NetworkDataCache;
import protocolsupport.protocol.utils.types.NetworkListenerState;

public class PacketDecoder extends AbstractModernWithReorderPacketDecoder {

	{
		registry.register(NetworkListenerState.HANDSHAKING, 0x00, SetProtocol.class);
		registry.register(NetworkListenerState.LOGIN, 0x00, LoginStart.class);
		registry.register(NetworkListenerState.LOGIN, 0x01, EncryptionResponse.class);
		registry.register(NetworkListenerState.STATUS, 0x00, ServerInfoRequest.class);
		registry.register(NetworkListenerState.STATUS, 0x01, Ping.class);
		registry.register(NetworkListenerState.PLAY, 0x00, KeepAlive.class);
		registry.register(NetworkListenerState.PLAY, 0x01, Chat.class);
		registry.register(NetworkListenerState.PLAY, 0x02, UseEntity.class);
		registry.register(NetworkListenerState.PLAY, 0x03, Flying.class);
		registry.register(NetworkListenerState.PLAY, 0x04, Position.class);
		registry.register(NetworkListenerState.PLAY, 0x05, Look.class);
		registry.register(NetworkListenerState.PLAY, 0x06, PositionLook.class);
		registry.register(NetworkListenerState.PLAY, 0x07, BlockDig.class);
		registry.register(NetworkListenerState.PLAY, 0x08, BlockPlace.class);
		registry.register(NetworkListenerState.PLAY, 0x09, HeldSlot.class);
		registry.register(NetworkListenerState.PLAY, 0x0A, Animation.class);
		registry.register(NetworkListenerState.PLAY, 0x0B, EntityAction.class);
		registry.register(NetworkListenerState.PLAY, 0x0C, SteerVehicle.class);
		registry.register(NetworkListenerState.PLAY, 0x0D, InventoryClose.class);
		registry.register(NetworkListenerState.PLAY, 0x0E, InventoryClick.class);
		registry.register(NetworkListenerState.PLAY, 0x0F, InventoryTransaction.class);
		registry.register(NetworkListenerState.PLAY, 0x10, CreativeSetSlot.class);
		registry.register(NetworkListenerState.PLAY, 0x11, InventoryEnchant.class);
		registry.register(NetworkListenerState.PLAY, 0x12, UpdateSign.class);
		registry.register(NetworkListenerState.PLAY, 0x13, PlayerAbilities.class);
		registry.register(NetworkListenerState.PLAY, 0x14, TabComplete.class);
		registry.register(NetworkListenerState.PLAY, 0x15, ClientSettings.class);
		registry.register(NetworkListenerState.PLAY, 0x16, ClientCommand.class);
		registry.register(NetworkListenerState.PLAY, 0x17, CustomPayload.class);
	}

	public PacketDecoder(Connection connection, NetworkDataCache sharedstorage) {
		super(connection, sharedstorage);
	}

}